package com.example.api_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api_java.model.JobWeeklyPlanReport;

@Repository
public interface JobWeeklyPlanReportRepository extends JpaRepository<JobWeeklyPlanReport, String> {

    @Query("SELECT r FROM JobWeeklyPlanReport r WHERE r.jobWeeklyPlan.id IN :jobWeeklyPlanIds")
    List<JobWeeklyPlanReport> findByJobWeeklyPlanIdIn(@Param("jobWeeklyPlanIds") List<String> jobWeeklyPlanIds);
}
