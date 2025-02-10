package com.example.api_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobWeeklyPlanReport {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "job_weekly_plan_id")
    private JobWeeklyPlan jobWeeklyPlan;

    private String jobType;
    private Integer totalDebt;
    private Integer completedCount;
    private Integer incompletedCount;
    private Integer totalDistance;

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

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }
}
