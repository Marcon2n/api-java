package com.example.api_java.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ReportDTO {
    private String date;
    private String jobType;
    private int totalDebt;
    private int completeDebt;
    private int incompleteDebt;
    private int totalDistance;
    private Float completedRate;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(int totalDebt) {
        this.totalDebt = totalDebt;
    }

    public int getCompleteDebt() {
        return completeDebt;
    }

    public void setCompleteDebt(int completeDebt) {
        this.completeDebt = completeDebt;
    }

    public int getIncompleteDebt() {
        return incompleteDebt;
    }

    public void setIncompleteDebt(int incompleteDebt) {
        this.incompleteDebt = incompleteDebt;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Float getCompletedRate() {
        return completedRate;
    }

    public void setCompletedRate(Float completedRate) {
        this.completedRate = completedRate;
    }

}
