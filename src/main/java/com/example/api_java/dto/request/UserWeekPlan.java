package com.example.api_java.dto.request;

import java.util.List;

public class UserWeekPlan {
    private String id;
    private WeekInfo weekInfo;
    private Report weekReport;
    private List<DailyTask> dailyTask;

    public UserWeekPlan(String id, WeekInfo weekInfo, Report weekReport, List<DailyTask> dailyTask) {
        this.id = id;
        this.weekInfo = weekInfo;
        this.weekReport = weekReport;
        this.dailyTask = dailyTask;
    }

    public String getId() {
        return id;
    }

    public WeekInfo getWeekInfo() {
        return weekInfo;
    }

    public Report getWeekReport() {
        return weekReport;
    }

    public List<DailyTask> getDailyTask() {
        return dailyTask;
    }  
}
