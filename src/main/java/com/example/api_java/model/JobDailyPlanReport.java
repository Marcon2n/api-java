package com.example.api_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobDailyPlanReport {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "job_weekly_plan_id")
    private JobWeeklyPlan jobWeeklyPlan;

    @ManyToOne
    @JoinColumn(name = "job_daily_plan_id")
    private JobDailyPlan jobDailyPlan;

    private String jobType;
    private Integer totalDebt;
    private Integer completedCount;
    private Integer incompletedCount;
    private Float totalDistance;

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

    public JobDailyPlan getJobDailyPlan() {
        return jobDailyPlan;
    }

    public void setJobDailyPlan(JobDailyPlan jobDailyPlan) {
        this.jobDailyPlan = jobDailyPlan;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(Integer totalDebt) {
        this.totalDebt = totalDebt;
    }

    public Integer getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Integer completedCount) {
        this.completedCount = completedCount;
    }

    public Integer getIncompletedCount() {
        return incompletedCount;
    }

    public void setIncompletedCount(Integer incompletedCount) {
        this.incompletedCount = incompletedCount;
    }

    public Float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Float totalDistance) {
        this.totalDistance = totalDistance;
    }

}
