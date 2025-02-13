package com.example.api_java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
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
import com.example.api_java.model.Geo;
import com.example.api_java.model.JobDailyPlan;
import com.example.api_java.model.JobDailyPlanReport;
import com.example.api_java.model.JobWeeklyPlan;
import com.example.api_java.model.JobWeeklyPlanReport;
import com.example.api_java.repository.JobDailyPlanReportRepository;
import com.example.api_java.repository.JobDailyPlanRepository;
import com.example.api_java.repository.JobWeeklyPlanReportRepository;
import com.example.api_java.repository.JobWeeklyPlanRepository;

@Service
public class JobPlanService {

        @Autowired
        private JobWeeklyPlanRepository jobWeeklyPlanRepository;

        @Autowired
        private JobWeeklyPlanReportRepository jobWeeklyPlanReportRepository;

        @Autowired
        private JobDailyPlanRepository jobDailyPlanRepository;

        @Autowired
        private JobDailyPlanReportRepository jobDailyPlanReportRepository;

        public Optional<UserWeekPlanDTO> getJobPlan(UserWeekPlanRequestDTO jobRequest) {
                // Fetch the record that matches the criteria from the job_weekly_plan table
                Optional<JobWeeklyPlan> weeklyPlanOpt = jobWeeklyPlanRepository.findByAssigneeAndWeekAndMonthAndYear(
                                jobRequest.getAssignee(), jobRequest.getWeek(), jobRequest.getMonth(),
                                jobRequest.getYear());

                // Check if a record is found and map it to UserWeekPlanDTO
                if (weeklyPlanOpt.isPresent()) {
                        JobWeeklyPlan weeklyPlan = weeklyPlanOpt.get();

                        ReportDTO weekReportDTO = getWeekReportFromPlan(weeklyPlan.getId());
                        List<DailyTaskDTO> dailyTaskDTO = getDailyTask(weeklyPlan.getId());
                        return Optional.of(mapToUserWeekPlanDTO(weeklyPlan, weekReportDTO, dailyTaskDTO));
                } else {
                        // Return an empty Optional if no record is found
                        return Optional.empty();
                }
        }

        private ReportDTO getWeekReportFromPlan(String jobWeeklyPlanId) {
                // Fetch the week report for the given jobWeeklyPlanId
                JobWeeklyPlanReport weekReport = jobWeeklyPlanReportRepository.findByJobWeeklyPlanId(jobWeeklyPlanId);

                // Map the week report to ReportDTO

                ReportDTO report = new ReportDTO();
                report.setJobType(weekReport.getJobType());
                report.setTotalDebt(weekReport.getTotalDebt());
                report.setCompleteDebt(weekReport.getCompletedCount());
                report.setIncompleteDebt(weekReport.getIncompletedCount());
                report.setTotalDistance(weekReport.getTotalDistance());
                return report;
        }

        private List<DailyTaskDTO> getDailyTask(String jobWeekPlanId) {
                System.out.println(jobWeekPlanId);
                // Get list of all job_daily_plan have same jobWeekPlanId
                List<JobDailyPlan> jobDailyPlans = jobDailyPlanRepository.findByJobWeeklyPlanId(jobWeekPlanId);

                // Check log list of all job_daily_plan
                // System.out.println(jobDailyPlans);
                // System.out.println(jobDailyPlans.size());

                // Create list from action_date
                Map<String, List<JobDailyPlan>> tasksByDate = jobDailyPlans.stream()
                                .collect(Collectors.groupingBy(JobDailyPlan::getActionDate, TreeMap::new,
                                                Collectors.toList()));

                // Check log list group by action_date
                // System.out.println(tasksByDate);

                List<DailyTaskDTO> dailyTaskDTOList = new ArrayList<>();
                for (String actionDate : tasksByDate.keySet()) {
                        List<JobDailyPlan> tasksForDate = tasksByDate.get(actionDate);

                        // Create report for current action_date in loop
                        // 1.1 The report need to calculate from job_daily_plan_report which same
                        // job_weekly_plan_id and field_type (field_type maybe check in token??)
                        // 1.2 Get list of JobDailyPlan IDs for the current action_date
                        List<String> jobDailyPlanIds = tasksForDate.stream().map(JobDailyPlan::getId)
                                        .collect(Collectors.toList());
                        // 1.3 Fetch JobDailyPlanReport records based on the list of JobDailyPlan IDs
                        List<JobDailyPlanReport> reportsForDate = jobDailyPlanReportRepository
                                        .findByJobDailyPlanIds(jobDailyPlanIds);

                        // Check log list of ids
                        // System.out.println(reportsForDate);

                        ReportDTO dailyReport = calculateDailyReport(reportsForDate);

                        // Create list tasks for current action_date in loop
                        // List<TaskDTO> tasks = List.of(new TaskDTO(jobWeekPlanId, 0, jobWeekPlanId,
                        // jobWeekPlanId,
                        // jobWeekPlanId, jobWeekPlanId, jobWeekPlanId, null, jobWeekPlanId));
                        // 2. Return all tasks in each action_date, need mapping geo again to return
                        // name, address outside, keep long, lat inside
                        List<TaskDTO> tasks = tasksForDate.stream().map(task -> {
                                Geo geo = task.getGeo();
                                GeoDTO geoDTO = new GeoDTO(geo.getLongitude(), geo.getLatitude());
                                return new TaskDTO(
                                                task.getId(),
                                                task.getOrder(),
                                                task.getJobType(),
                                                task.getDebtCode(),
                                                task.getCif(),
                                                geo.getName(),
                                                geo.getAddress(),
                                                geoDTO,
                                                task.getStatus());
                        }).collect(Collectors.toList());

                        // Create dailyTask for current action_date in loop --> Final result
                        DailyTaskDTO dailyTaskDTO = new DailyTaskDTO(actionDate, dailyReport, tasks);
                        dailyTaskDTOList.add(dailyTaskDTO);
                }

                return dailyTaskDTOList;
        };

        private ReportDTO calculateDailyReport(List<JobDailyPlanReport> reports) {
                int totalDebt = reports.size();
                int completedCount = (int) reports.stream()
                                .filter(report -> "COMPLETED".equals(report.getJobDailyPlan().getStatus())).count();
                int incompletedCount = totalDebt - completedCount;
                int totalDistance = reports.stream().mapToInt(JobDailyPlanReport::getTotalDistance).sum();

                ReportDTO report = new ReportDTO();
                report.setJobType("FIELD");
                report.setTotalDebt(totalDebt);
                report.setCompleteDebt(completedCount);
                report.setIncompleteDebt(incompletedCount);
                report.setTotalDistance(totalDistance);

                return report;
        }

        private UserWeekPlanDTO mapToUserWeekPlanDTO(JobWeeklyPlan weeklyPlan, ReportDTO weekReportDTO,
                        List<DailyTaskDTO> dailyTaskDTOList) {
                WeekInfoDTO weekInfoDTO = new WeekInfoDTO(
                                weeklyPlan.getWeek(), weeklyPlan.getMonth(), weeklyPlan.getYear(),
                                weeklyPlan.getFromDate(), weeklyPlan.getToDate());

                return new UserWeekPlanDTO(
                                weeklyPlan.getId(), weekInfoDTO, weekReportDTO, dailyTaskDTOList);
        }
}
