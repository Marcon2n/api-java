package com.example.api_java.dto.request;

import java.util.Date;

import com.example.api_java.util.JobType;

public class ReportDTO {
    private Date date;
    private JobType jobType;
    private int totalDebt;
    private int completeDebt;
    private int incompleteDebt;
    private int totalDistance;
    private float completedRate;

    public ReportDTO(JobType jobType, int totalDebt, int completeDebt, int incompleteDebt, int totalDistance) {
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

    public JobType getJobType() {
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
}
