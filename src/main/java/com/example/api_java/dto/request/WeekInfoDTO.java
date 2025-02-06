package com.example.api_java.dto.request;

public class WeekInfoDTO {
    private int week;
    private int month;
    private int year;
    private String fromDate;
    private String toDate;

    public WeekInfoDTO(int week, int month, int year, String fromDate, String toDate) {
        this.week = week;
        this.month = month;
        this.year = year;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public int getWeek() {
        return week;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

}
