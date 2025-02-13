package com.example.api_java.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_java.dto.request.DailyReportUserDTO;
import com.example.api_java.dto.request.ReportDTO;
import com.example.api_java.dto.request.UserDateRangeRequest;
import com.example.api_java.model.JobDailyPlan;
import com.example.api_java.repository.JobDailyPlanRepository;

@Service
public class JobDateRangeReportService {
    @Autowired
    private JobDailyPlanRepository jobDailyPlanRepository;

    public Optional<DailyReportUserDTO> getUserDateRangeReport(UserDateRangeRequest jobRequest) {
        // Get list of all date in range request
        List<String> dateRange = getDateRange(jobRequest.getFromDate(), jobRequest.getToDate());
        for (String date : dateRange) {
            System.out.println(date);
        }

        // Get all job_daily_plan which assignee same as jobRequest assignee and
        // action_date in range date Range
        List<JobDailyPlan> jobInRange = jobDailyPlanRepository
                .findByAssigneeAndActionDateRange(jobRequest.getAssignee(), dateRange);
        System.out.println(jobInRange);

        // Need to return List<ReportDTO> from jobInRange group by action_date and have
        // complete_count, incomplete_count, total_debt, completed_rate
        Map<String, ReportDTO> reportMap = new HashMap<>();

        for (JobDailyPlan job : jobInRange) {
            String actionDate = job.getActionDate();
            ReportDTO defaultReport = new ReportDTO();
            defaultReport.setDate(actionDate);
            defaultReport.setTotalDebt(0);
            defaultReport.setCompleteDebt(0);
            defaultReport.setIncompleteDebt(0);
            defaultReport.setCompletedRate((float) 0);
            ReportDTO report = reportMap.getOrDefault(actionDate, defaultReport);

            // Update the report data
            report.setTotalDebt(report.getTotalDebt() + 1);
            if ("COMPLETED".equals(job.getStatus())) {
                report.setCompleteDebt(report.getCompleteDebt() + 1);
            } else {
                report.setIncompleteDebt(report.getIncompleteDebt() + 1);
            }

            reportMap.put(actionDate, report);
        }

        // Calculate the completed_rate for each report
        for (ReportDTO report : reportMap.values()) {
            int total = report.getTotalDebt();
            if (total > 0) {
                report.setCompletedRate((float) report.getCompleteDebt() / total * 100);
            }
        }

        // Create a list of reports from the map
        List<ReportDTO> reports = new ArrayList<>(reportMap.values());

        // Sort the reports list by action_date in ascending order
        reports.sort(Comparator.comparing(ReportDTO::getDate));

        DailyReportUserDTO report = new DailyReportUserDTO(jobRequest.getAssignee(), reports);

        return Optional.of(report);
    }

    private List<String> getDateRange(String from_date, String to_date) {
        List<String> dateRange = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date startDate = dateFormat.parse(from_date);
            Date endDate = dateFormat.parse(to_date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (!calendar.getTime().after(endDate)) {
                dateRange.add(dateFormat.format(calendar.getTime()));
                calendar.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateRange;
    }
}
