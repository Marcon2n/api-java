package com.example.api_java.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportDTO {
    private Date date;
    private String jobType;
    private int totalDebt;
    private int completeDebt;
    private int incompleteDebt;
    private int totalDistance;
    private Float completedRate;

    // Constructor with date and completedRate
    public ReportDTO(Date date, String jobType, int totalDebt, int completeDebt, int incompleteDebt, int totalDistance,
            Float completedRate) {
        this.date = date;
        this.jobType = jobType;
        this.totalDebt = totalDebt;
        this.completeDebt = completeDebt;
        this.incompleteDebt = incompleteDebt;
        this.totalDistance = totalDistance;
        this.completedRate = completedRate;
    }

    // Constructor without date and completedRate
    public ReportDTO(String jobType, int totalDebt, int completeDebt, int incompleteDebt, int totalDistance) {
        this(null, jobType, totalDebt, completeDebt, incompleteDebt, totalDistance, null);
    }

    // Getters and setters
    public Date getDate() {
        return date;
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

    public Float getCompletedRate() {
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

    public void setCompletedRate(Float completedRate) {
        this.completedRate = completedRate;
    }
}
