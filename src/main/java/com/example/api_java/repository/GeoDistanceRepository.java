package com.example.api_java.repository;

import org.springframework.stereotype.Repository;
import com.example.api_java.model.GeoDistance;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GeoDistanceRepository extends JpaRepository<GeoDistance, String> {

}
