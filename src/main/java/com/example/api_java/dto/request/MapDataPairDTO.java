package com.example.api_java.dto.request;

public class MapDataPairDTO {
    private MapDataPointDTO from;
    private MapDataPointDTO to;
    private int distance;

    public MapDataPairDTO(MapDataPointDTO from, MapDataPointDTO to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public MapDataPointDTO getFrom() {
        return from;
    }

    public MapDataPointDTO getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }
}
