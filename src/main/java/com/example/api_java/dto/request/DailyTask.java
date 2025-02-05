package com.example.api_java.dto.request;

import java.util.Date;
import java.util.List;

public class DailyTask {
    private Date actionDate;
    private WeekInfo weekInfo;
    private List<Report> weekReport;
    private List<Task> tasks;

    public DailyTask(Date actionDate, WeekInfo weekInfo, List<Report> weekReport, List<Task> tasks) {
        this.actionDate = actionDate;
        this.weekInfo = weekInfo;
        this.weekReport = weekReport;
        this.tasks = tasks;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public WeekInfo getWeekInfo() {
        return weekInfo;
    }

    public List<Report> getWeekReport() {
        return weekReport;
    }

    public List<Task> getTasks() {
        return tasks;
    }   
}
