package com.example.api_java.dto.request;

public class MapDataPoint {
    private String name;
    private String address;
    private Geo geo;

    public MapDataPoint(String name, String address, Geo geo) {
        this.name = name;
        this.address = address;
        this.geo = geo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Geo getGeo() {
        return geo;
    }
}
