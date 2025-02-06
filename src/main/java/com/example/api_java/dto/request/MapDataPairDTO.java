package com.example.api_java.dto.request;

public class MapDataPairDTO {
    private MapDataPointDTO from;
    private MapDataPointDTO to;

    public MapDataPairDTO(MapDataPointDTO from, MapDataPointDTO to) {
        this.from = from;
        this.to = to;
    }

    public MapDataPointDTO getFrom() {
        return from;
    }

    public MapDataPointDTO getTo() {
        return to;
    }
}
