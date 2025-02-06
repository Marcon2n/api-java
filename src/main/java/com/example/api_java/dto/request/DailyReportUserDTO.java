package com.example.api_java.dto.request;

import java.util.List;

public class DailyReportUserDTO {
    private String assignee;
    private List<ReportDTO> data;

    public DailyReportUserDTO(String assignee, List<ReportDTO> data) {
        this.assignee = assignee;
        this.data = data;
    }

    public String getAssignee() {
        return assignee;
    }

    public List<ReportDTO> getData() {
        return data;
    }
}
