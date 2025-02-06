package com.example.api_java.dto.request;

import java.util.List;

public class UserWeekPlanDTO {
    private String id;
    private WeekInfoDTO weekInfo;
    private ReportDTO weekReport;
    private List<DailyTaskDTO> dailyTask;

    public UserWeekPlanDTO(String id, WeekInfoDTO weekInfo, ReportDTO weekReport, List<DailyTaskDTO> dailyTask) {
        this.id = id;
        this.weekInfo = weekInfo;
        this.weekReport = weekReport;
        this.dailyTask = dailyTask;
    }

    public String getId() {
        return id;
    }

    public WeekInfoDTO getWeekInfo() {
        return weekInfo;
    }

    public ReportDTO getWeekReport() {
        return weekReport;
    }

    public List<DailyTaskDTO> getDailyTask() {
        return dailyTask;
    }
}
