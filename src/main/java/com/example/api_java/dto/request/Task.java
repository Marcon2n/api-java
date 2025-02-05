package com.example.api_java.dto.request;

import com.example.api_java.util.ActionStatus;

public class Task {
    private String id;
    private int order;
    private String jobType;
    private String debtCode;
    private String cif;
    private String cusName;
    private String cusAddress;
    private Geo geo;
    private ActionStatus status;

    public Task(String id, int order, String jobType, String debtCode, String cif, String cusName, String cusAddress, Geo geo, ActionStatus status) {
        this.id = id;
        this.order = order;
        this.jobType = jobType;
        this.debtCode = debtCode;
        this.cif = cif;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.geo = geo;
        this.status = status;
    }

    public String getId() {
        return id;
    }
    public int getOrder() {
        return order;
    }
    public String getJobType() {
        return jobType;
    }
    public String getDebtCode() {
        return debtCode;
    }
    public String getCif() {
        return cif;
    }
    public String getCusName() {
        return cusName;
    }
    public String getCusAddress() {
        return cusAddress;
    }

    public Geo getGeo() {
        return geo;
    }

    public ActionStatus getStatus() {
        return status;
    }
}
