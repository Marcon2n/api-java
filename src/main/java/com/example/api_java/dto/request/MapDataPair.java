package com.example.api_java.dto.request;

public class MapDataPair {
    private MapDataPoint from;
    private MapDataPoint to;

    public MapDataPair(MapDataPoint from, MapDataPoint to) {
        this.from = from;
        this.to = to;
    }

    public MapDataPoint getFrom() {
        return from;
    }

    public MapDataPoint getTo() {
        return to;
    }
}
