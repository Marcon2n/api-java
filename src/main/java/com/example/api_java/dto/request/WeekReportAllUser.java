package com.example.api_java.dto.request;

import java.util.List;

public class WeekReportAllUser {
    private String assignee;
    private Report weekReport;
    private List<Report> dailyReport;

    public WeekReportAllUser(String assignee, Report weekReport, List<Report> dailyReport) {
        this.assignee = assignee;
        this.weekReport = weekReport;
        this.dailyReport = dailyReport;
    }

    public String getAssignee() {
        return assignee;
    }
    public Report getWeekReport() {
        return weekReport;
    }
    public List<Report> getDailyReport() {
        return dailyReport;
    }
}
