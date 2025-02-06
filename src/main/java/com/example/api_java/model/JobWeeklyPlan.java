package com.example.api_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobWeeklyPlan {
    @Id
    private String id;
    private String assignee;
    private String kpi;
    private Integer week;
    private Integer month;
    private Integer year;
    private String fromDate;
    private String toDate;

    @ManyToOne
    @JoinColumn(name = "start_geo_id")
    private Geo startGeo;

    private Boolean locked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getKpi() {
        return kpi;
    }

    public void setKpi(String kpi) {
        this.kpi = kpi;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Geo getStartGeo() {
        return startGeo;
    }

    public void setStartGeo(Geo startGeo) {
        this.startGeo = startGeo;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

}