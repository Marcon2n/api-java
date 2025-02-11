package com.example.api_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api_java.model.JobDailyPlanReport;

@Repository
public interface JobDailyPlanReportRepository extends JpaRepository<JobDailyPlanReport, String> {

    @Query("SELECT r FROM JobDailyPlanReport r WHERE r.jobDailyPlan.id IN :jobDailyPlanIds")
    List<JobDailyPlanReport> findByJobDailyPlanIds(@Param("jobDailyPlanIds") List<String> jobDailyPlanIds);
}
