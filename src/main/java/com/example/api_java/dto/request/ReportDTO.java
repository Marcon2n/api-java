package com.example.api_java.dto.request;

import java.util.Date;

public class ReportDTO {
    private Date date;
    private String jobType;
    private int totalDebt;
    private int completeDebt;
    private int incompleteDebt;
    private int totalDistance;
    private float completedRate;

    public ReportDTO(String jobType, int totalDebt, int completeDebt, int incompleteDebt, int totalDistance) {
        this.jobType = jobType;
        this.totalDebt = totalDebt;
        this.completeDebt = completeDebt;
        this.incompleteDebt = incompleteDebt;
        this.totalDistance = totalDistance;
    }

    public ReportDTO(Date date, int totalDebt, int completeDebt, int incompleteDebt, int completedRate) {
        this.date = date;
        this.totalDebt = totalDebt;
        this.completeDebt = completeDebt;
        this.incompleteDebt = incompleteDebt;
        this.completedRate = this.completeDebt / this.totalDebt;
    }

    public String getJobType() {
        return jobType;
    }

    public int getTotalDebt() {
        return totalDebt;
    }

    public int getCompleteDebt() {
        return completeDebt;
    }

    public int getIncompleteDebt() {
        return incompleteDebt;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public Date getDate() {
        return date;
    }

    public float getCompletedRate() {
        return completedRate;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setTotalDebt(int totalDebt) {
        this.totalDebt = totalDebt;
    }

    public void setCompleteDebt(int completeDebt) {
        this.completeDebt = completeDebt;
    }

    public void setIncompleteDebt(int incompleteDebt) {
        this.incompleteDebt = incompleteDebt;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setCompletedRate(float completedRate) {
        this.completedRate = completedRate;
    }
}
