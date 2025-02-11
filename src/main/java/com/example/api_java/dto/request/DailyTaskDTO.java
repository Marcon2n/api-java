package com.example.api_java.dto.request;

import java.util.List;

public class DailyTaskDTO {
    private String actionDate;
    private ReportDTO report;
    private List<TaskDTO> tasks;

    public DailyTaskDTO(String actionDate, ReportDTO report, List<TaskDTO> tasks) {
        this.actionDate = actionDate;
        this.report = report;
        this.tasks = tasks;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public ReportDTO getReport() {
        return report;
    }

    public void setReport(ReportDTO report) {
        this.report = report;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

}
