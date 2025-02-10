package com.example.api_java.dto.request;

import java.util.List;

public class DailyTaskDTO {
    private String actionDate;
    private List<ReportDTO> report;
    private List<TaskDTO> tasks;

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public List<ReportDTO> getReport() {
        return report;
    }

    public void setReport(List<ReportDTO> report) {
        this.report = report;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

}
