package com.example.api_java.dto.request;

public class MapDataPointDTO {
    private String name;
    private String address;
    private GeoDTO geo;

    public MapDataPointDTO(String name, String address, GeoDTO geo) {
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

    public GeoDTO getGeo() {
        return geo;
    }
}
