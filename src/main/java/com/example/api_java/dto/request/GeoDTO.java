package com.example.api_java.dto.request;

public class GeoDTO {
    private Float geoLong;
    private Float geoLat;

    public GeoDTO(Float geoLong, Float geoLat) {
        this.geoLong = geoLong;
        this.geoLat = geoLat;
    }

    public Float getGeoLong() {
        return geoLong;
    }

    public Float getGeoLat() {
        return geoLat;
    }
}
