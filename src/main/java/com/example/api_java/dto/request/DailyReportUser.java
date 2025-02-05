package com.example.api_java.dto.request;

import java.util.List;

public class DailyReportUser {
    private String assignee;
    private List<Report> data;

    public DailyReportUser(String assignee, List<Report> data) {
        this.assignee = assignee;
        this.data = data;
    }

    public String getAssignee() {
        return assignee;
    }

    public List<Report> getData() {
        return data;
    }
}
