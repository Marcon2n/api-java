package com.example.api_java.dto.request;

import java.util.Date;

public class WeekInfo {
    private int week;
    private int month;
    private int year;
    private Date fromDate;
    private Date toDate;

    public WeekInfo(int week, int month, int year, Date fromDate, Date toDate) {
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
    public Date getFromDate() {
        return fromDate;
    }
    public Date getToDate() {
        return toDate;
    }

    

}
