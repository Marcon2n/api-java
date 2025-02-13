package com.example.api_java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_java.dto.request.ReportDTO;
import com.example.api_java.dto.request.UserWeekPlanRequestDTO;
import com.example.api_java.dto.request.WeekReportAllUserDTO;
import com.example.api_java.model.JobDailyPlan;
import com.example.api_java.model.JobDailyPlanReport;
import com.example.api_java.model.JobWeeklyPlan;
import com.example.api_java.model.JobWeeklyPlanReport;
import com.example.api_java.repository.JobDailyPlanReportRepository;
import com.example.api_java.repository.JobDailyPlanRepository;
import com.example.api_java.repository.JobWeeklyPlanReportRepository;
import com.example.api_java.repository.JobWeeklyPlanRepository;

@Service
public class JobWeekReportAllUserService {
    @Autowired
    private JobWeeklyPlanRepository jobWeeklyPlanRepository;

    @Autowired
    private JobWeeklyPlanReportRepository jobWeeklyPlanReportRepository;

    @Autowired
    private JobDailyPlanRepository jobDailyPlanRepository;

    @Autowired
    private JobDailyPlanReportRepository jobDailyPlanReportRepository;

    public Optional<List<WeekReportAllUserDTO>> getWeekReportAllUser(UserWeekPlanRequestDTO jobRequest) {
        List<JobWeeklyPlan> plans = jobWeeklyPlanRepository.findWeeklyReportAllUser(
                jobRequest.getWeek(), jobRequest.getMonth(), jobRequest.getYear()).orElse(List.of());
        List<WeekReportAllUserDTO> reports = IntStream.range(0, plans.size())
                .mapToObj(i -> {
                    JobWeeklyPlan plan = plans.get(i);
                    ReportDTO weekReport = getWeekReportFromPlan(plan.getId());
                    List<ReportDTO> dailyReport = getDailyReportUser(plan.getId());
                    WeekReportAllUserDTO report = new WeekReportAllUserDTO(plan.getAssignee(), weekReport, dailyReport);
                    return report;
                })
                .collect(Collectors.toList());
        System.out.println(reports);

        return Optional.of(reports);
    };

    private ReportDTO getWeekReportFromPlan(String jobWeeklyPlanId) {
        // Fetch the week report for the given jobWeeklyPlanId
        JobWeeklyPlanReport weekReport = jobWeeklyPlanReportRepository.findByJobWeeklyPlanId(jobWeeklyPlanId);

        ReportDTO report = new ReportDTO();
        report.setTotalDebt(weekReport.getTotalDebt());
        report.setCompleteDebt(weekReport.getCompletedCount());
        report.setIncompleteDebt(weekReport.getIncompletedCount());
        report.setCompletedRate((float) weekReport.getCompletedCount() / weekReport.getTotalDebt() * 100);
        return report;
    }

    private List<ReportDTO> getDailyReportUser(String weekPlanId) {
        List<JobDailyPlan> jobDailyPlans = jobDailyPlanRepository.findByJobWeeklyPlanId(weekPlanId);

        Map<String, List<JobDailyPlan>> tasksByDate = jobDailyPlans.stream()
                .collect(Collectors.groupingBy(JobDailyPlan::getActionDate, TreeMap::new,
                        Collectors.toList()));
        List<ReportDTO> dailyReportList = new ArrayList<>();
        for (String actionDate : tasksByDate.keySet()) {
            List<JobDailyPlan> tasksForDate = tasksByDate.get(actionDate);
            List<String> jobDailyPlanIds = tasksForDate.stream().map(JobDailyPlan::getId)
                    .collect(Collectors.toList());
            List<JobDailyPlanReport> reportsForDate = jobDailyPlanReportRepository
                    .findByJobDailyPlanIds(jobDailyPlanIds);

            ReportDTO report = calculateDailyReport(reportsForDate, actionDate);
            dailyReportList.add(report);
        }

        return dailyReportList;
    }

    private ReportDTO calculateDailyReport(List<JobDailyPlanReport> reports, String date) {
        int totalDebt = reports.size();
        int completedCount = (int) reports.stream()
                .filter(report -> "COMPLETED".equals(report.getJobDailyPlan().getStatus())).count();
        int incompletedCount = totalDebt - completedCount;

        ReportDTO report = new ReportDTO();
        report.setDate(date);
        report.setTotalDebt(totalDebt);
        report.setCompleteDebt(completedCount);
        report.setIncompleteDebt(incompletedCount);
        report.setCompletedRate((float) completedCount / totalDebt * 100);

        return report;
    }

}
