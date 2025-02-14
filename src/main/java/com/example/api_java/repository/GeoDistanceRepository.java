package com.example.api_java.repository;

import org.springframework.stereotype.Repository;
import com.example.api_java.model.GeoDistance;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface GeoDistanceRepository extends JpaRepository<GeoDistance, String> {

    @Query("SELECT g FROM GeoDistance g WHERE g.fromGeo.id = :fromGeoId AND g.toGeo.id = :toGeoId")
    Optional<GeoDistance> findByFromGeoIdAndToGeoId(@Param("fromGeoId") String fromGeoId,
            @Param("toGeoId") String toGeoId);
}
