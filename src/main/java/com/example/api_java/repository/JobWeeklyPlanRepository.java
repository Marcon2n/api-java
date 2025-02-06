package com.example.api_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_java.model.JobWeeklyPlan;

@Repository
public interface JobWeeklyPlanRepository extends JpaRepository<JobWeeklyPlan, String> {

}
