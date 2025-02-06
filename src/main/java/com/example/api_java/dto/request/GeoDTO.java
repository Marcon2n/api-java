package com.example.api_java.dto.request;

public class GeoDTO {
    private String geoLong;
    private String geoLat;

    public GeoDTO(String geoLong, String geoLat) {
        this.geoLong = geoLong;
        this.geoLat = geoLat;
    }

    public String getGeoLong() {
        return geoLong;
    }

    public String getGeoLat() {
        return geoLat;
    }
}
