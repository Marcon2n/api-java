package com.example.api_java.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWeekPlanRequestDTO {
    private String assignee;
    private int week;
    private int month;
    private int year;

    public UserWeekPlanRequestDTO() {
    };

    public UserWeekPlanRequestDTO(int week, int month, int year) {
        this.week = week;
        this.month = month;
        this.year = year;
    };

    public UserWeekPlanRequestDTO(String assignee, int week, int month, int year) {
        this.assignee = assignee;
        this.week = week;
        this.month = month;
        this.year = year;
    }

    public String getAssignee() {
        return assignee;
    }

    public int getWeek() {
        return week;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    };

    @Override
    public String toString() {
        return "Request{" +
                ", assignee=" + assignee +
                ", week='" + week + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
