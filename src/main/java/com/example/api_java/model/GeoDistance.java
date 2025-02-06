package com.example.api_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class GeoDistance {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "from_geo_id")
    private Geo fromGeo;

    @ManyToOne
    @JoinColumn(name = "to_geo_id")
    private Geo toGeo;

    private Float distance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Geo getFromGeo() {
        return fromGeo;
    }

    public void setFromGeo(Geo fromGeo) {
        this.fromGeo = fromGeo;
    }

    public Geo getToGeo() {
        return toGeo;
    }

    public void setToGeo(Geo toGeo) {
        this.toGeo = toGeo;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
