package com.example.api_java.dto.request;

import com.example.api_java.util.JobType;

public class Report {
    private JobType jobType;
    private int totalDebt;
    private int completeDebt;
    private int incompleteDebt;
    private int totalDistance;

    public Report(JobType jobType, int totalDebt, int completeDebt, int incompleteDebt, int totalDistance) {
        this.jobType = jobType;
        this.totalDebt = totalDebt;
        this.completeDebt = completeDebt;
        this.incompleteDebt = incompleteDebt;
        this.totalDistance = totalDistance;
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

    
}
