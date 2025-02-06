package com.example.api_java.dto.request;

import java.util.List;

public class WeekReportAllUserDTO {
    private String assignee;
    private ReportDTO weekReport;
    private List<ReportDTO> dailyReport;

    public WeekReportAllUserDTO(String assignee, ReportDTO weekReport, List<ReportDTO> dailyReport) {
        this.assignee = assignee;
        this.weekReport = weekReport;
        this.dailyReport = dailyReport;
    }

    public String getAssignee() {
        return assignee;
    }

    public ReportDTO getWeekReport() {
        return weekReport;
    }

    public List<ReportDTO> getDailyReport() {
        return dailyReport;
    }
}
