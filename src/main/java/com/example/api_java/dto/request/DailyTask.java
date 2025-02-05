package com.example.api_java.dto.request;

import java.util.Date;
import java.util.List;

public class DailyTask {
    private Date actionDate;
    private List<Report> report;
    private List<Task> tasks;

    public DailyTask(Date actionDate, List<Report> report, List<Task> tasks) {
        this.actionDate = actionDate;
        this.report = report;
        this.tasks = tasks;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public List<Report> getReport() {
        return report;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
