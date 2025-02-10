package com.example.api_java.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_java.dto.request.DailyTaskDTO;
import com.example.api_java.dto.request.GeoDTO;
import com.example.api_java.dto.request.ReportDTO;
import com.example.api_java.dto.request.TaskDTO;
import com.example.api_java.dto.request.UserWeekPlanDTO;
import com.example.api_java.dto.request.UserWeekPlanRequestDTO;
import com.example.api_java.dto.request.WeekInfoDTO;
import com.example.api_java.model.JobDailyPlan;
import com.example.api_java.model.JobWeeklyPlan;
import com.example.api_java.repository.JobDailyPlanReportRepository;
import com.example.api_java.repository.JobDailyPlanRepository;
import com.example.api_java.repository.JobWeeklyPlanReportRepository;
import com.example.api_java.repository.JobWeeklyPlanRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JobPlanService {

        private final JobWeeklyPlanRepository jobWeeklyPlanRepository;
        private final JobDailyPlanRepository jobDailyPlanRepository;
        private final JobWeeklyPlanReportRepository jobWeeklyPlanReportRepository;
        private final JobDailyPlanReportRepository jobDailyPlanReportRepository;

        @Autowired
        public JobPlanService(JobWeeklyPlanRepository jobWeeklyPlanRepository,
                        JobDailyPlanRepository jobDailyPlanRepository,
                        JobWeeklyPlanReportRepository jobWeeklyPlanReportRepository,
                        JobDailyPlanReportRepository jobDailyPlanReportRepository) {
                this.jobWeeklyPlanRepository = jobWeeklyPlanRepository;
                this.jobDailyPlanRepository = jobDailyPlanRepository;
                this.jobWeeklyPlanReportRepository = jobWeeklyPlanReportRepository;
                this.jobDailyPlanReportRepository = jobDailyPlanReportRepository;
        }

        public UserWeekPlanDTO getJobPlan(UserWeekPlanRequestDTO jobRequest) {
                System.out.println(jobRequest);
                List<JobWeeklyPlan> jobWeeklyPlans = jobWeeklyPlanRepository.findByAssigneeAndWeekAndMonthAndYear(
                                jobRequest.getAssignee(), jobRequest.getWeek(), jobRequest.getMonth(),
                                jobRequest.getYear())
                                .orElseThrow(() -> new EntityNotFoundException("JobWeeklyPlans not found"));

                // Extracting IDs
                List<String> jobWeeklyPlanIds = jobWeeklyPlans.stream()
                                .map(JobWeeklyPlan::getId)
                                .collect(Collectors.toList());

                WeekInfoDTO weekInfo = new WeekInfoDTO(
                                jobWeeklyPlans.get(0).getWeek(),
                                jobWeeklyPlans.get(0).getMonth(),
                                jobWeeklyPlans.get(0).getYear(),
                                jobWeeklyPlans.get(0).getFromDate(),
                                jobWeeklyPlans.get(0).getToDate());

                // ReportDTO weekReport =
                // jobWeeklyPlanReportRepository.findByJobWeeklyPlanIdIn(jobWeeklyPlanIds)
                // .stream()
                // .map(report -> new ReportDTO(
                // report.getJobType(),
                // report.getTotalDebt(),
                // report.getCompletedCount(),
                // report.getIncompletedCount(),
                // report.getTotalDistance()))
                // .reduce(new ReportDTO("", 0, 0, 0, 0), (dto, report) -> {
                // dto.setTotalDebt(dto.getTotalDebt() + report.getTotalDebt());
                // dto.setCompleteDebt(dto.getCompleteDebt() + report.getCompleteDebt());
                // dto.setIncompleteDebt(dto.getIncompleteDebt() + report.getIncompleteDebt());
                // dto.setTotalDistance(dto.getTotalDistance() + report.getTotalDistance());
                // return dto;
                // }, (dto1, dto2) -> {
                // dto1.setTotalDebt(dto1.getTotalDebt() + dto2.getTotalDebt());
                // dto1.setCompleteDebt(dto1.getCompleteDebt() + dto2.getCompleteDebt());
                // dto1.setIncompleteDebt(dto1.getIncompleteDebt() + dto2.getIncompleteDebt());
                // dto1.setTotalDistance(dto1.getTotalDistance() + dto2.getTotalDistance());
                // return dto1;
                // });

                // weekReport.setCompletedRate((float) weekReport.getCompleteDebt() /
                // weekReport.getTotalDebt());

                ReportDTO WeekReportTest = new ReportDTO("", 0, 0, 0, 0);

                String fromDate = jobWeeklyPlans.get(0).getFromDate();
                String toDate = jobWeeklyPlans.get(0).getToDate();

                List<DailyTaskDTO> dailyTasks = jobDailyPlanRepository.findByJobWeeklyPlanIdIn(jobWeeklyPlanIds)
                                .stream()
                                .filter(task -> task.getActionDate().compareTo(fromDate) >= 0 &&
                                                task.getActionDate().compareTo(toDate) <= 0)
                                .collect(Collectors.groupingBy(JobDailyPlan::getActionDate))
                                .entrySet()
                                .stream()
                                .map(entry -> {
                                        DailyTaskDTO dailyTask = new DailyTaskDTO();
                                        dailyTask.setActionDate(entry.getKey());

                                        List<ReportDTO> dailyReport = jobDailyPlanReportRepository
                                                        .findByJobWeeklyPlanIdIn(jobWeeklyPlanIds)
                                                        .stream()
                                                        .filter(report -> jobWeeklyPlanIds
                                                                        .contains(report.getJobWeeklyPlan().getId()))
                                                        .map(report -> new ReportDTO(report.getJobType(),
                                                                        report.getTotalDebt(),
                                                                        report.getCompletedCount(),
                                                                        report.getIncompletedCount(),
                                                                        report.getTotalDistance()))
                                                        .collect(Collectors.toList());

                                        dailyTask.setReport(dailyReport);

                                        List<TaskDTO> tasks = entry.getValue()
                                                        .stream()
                                                        .map(task -> {
                                                                GeoDTO geo = new GeoDTO(task.getGeo().getLongitude(),
                                                                                task.getGeo().getLatitude());
                                                                TaskDTO dto = new TaskDTO(task.getId(), task.getOrder(),
                                                                                task.getJobType(), task.getDebtCode(),
                                                                                task.getCif(), task.getGeo().getName(),
                                                                                task.getGeo().getAddress(), geo,
                                                                                task.getStatus());
                                                                return dto;
                                                        })
                                                        .collect(Collectors.toList());

                                        dailyTask.setTasks(tasks);
                                        return dailyTask;
                                })
                                .collect(Collectors.toList());

                List<DailyTaskDTO> dailyTaskListTest = List.of(new DailyTaskDTO(), new DailyTaskDTO());

                UserWeekPlanDTO jobPlanDTO = new UserWeekPlanDTO(null, weekInfo, WeekReportTest, dailyTaskListTest);

                return jobPlanDTO;
        }
}
