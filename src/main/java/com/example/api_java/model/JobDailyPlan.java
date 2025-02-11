package com.example.api_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobDailyPlan {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "job_weekly_plan_id")
    private JobWeeklyPlan jobWeeklyPlan;

    private String assignee;
    private String assignor;
    private String debtId;
    private String debtCode;
    private String cif;

    @ManyToOne
    @JoinColumn(name = "geo_id")
    private Geo geo;

    private String actionDate;
    private String jobType;
    private Integer order;
    private String status;
    private Boolean locked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JobWeeklyPlan getJobWeeklyPlan() {
        return jobWeeklyPlan;
    }

    public void setJobWeeklyPlan(JobWeeklyPlan jobWeeklyPlan) {
        this.jobWeeklyPlan = jobWeeklyPlan;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public String getDebtId() {
        return debtId;
    }

    public void setDebtId(String debtId) {
        this.debtId = debtId;
    }

    public String getDebtCode() {
        return debtCode;
    }

    public void setDebtCode(String debtCode) {
        this.debtCode = debtCode;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "JobDailyPlan{" +
                "id='" + id + '\'' +
                ", jobWeeklyPlan=" + jobWeeklyPlan +
                ", assignee='" + assignee + '\'' +
                ", assignor='" + assignor + '\'' +
                ", debtId='" + debtId + '\'' +
                ", debtCode='" + debtCode + '\'' +
                ", cif='" + cif + '\'' +
                ", geo=" + geo +
                ", actionDate='" + actionDate + '\'' +
                ", jobType='" + jobType + '\'' +
                ", order=" + order +
                ", status='" + status + '\'' +
                ", locked=" + locked +
                '}';
    }
}
