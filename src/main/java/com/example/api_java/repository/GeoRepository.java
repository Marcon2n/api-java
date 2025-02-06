package com.example.api_java.repository;

import org.springframework.stereotype.Repository;
import com.example.api_java.model.Geo;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GeoRepository extends JpaRepository<Geo, String> {

}
