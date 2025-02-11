package com.example.api_java.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Geo {
    @Id
    private String id;
    private String name;
    private String address;
    private String objectId;
    private String objectType;
    @Column(name = "long")
    private Float longitude;
    @Column(name = "lat")
    private Float latitude;
    @Column(name = "updated_time")
    private LocalDateTime upDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(LocalDateTime upDateTime) {
        this.upDateTime = upDateTime;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", objectId='" + objectId + '\'' +
                ", objectType='" + objectType + '\'' +
                ", long='" + longitude + '\'' +
                ", lat='" + latitude + '\'' +
                ", updateTime=" + upDateTime +
                '}';
    }

}
