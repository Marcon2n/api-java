package com.example.api_java.dto.request;

import java.util.Date;
import java.util.List;

public class DailyTaskDTO {
    private Date actionDate;
    private List<ReportDTO> report;
    private List<TaskDTO> tasks;

    public DailyTaskDTO(Date actionDate, List<ReportDTO> report, List<TaskDTO> tasks) {
        this.actionDate = actionDate;
        this.report = report;
        this.tasks = tasks;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public List<ReportDTO> getReport() {
        return report;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }
}
