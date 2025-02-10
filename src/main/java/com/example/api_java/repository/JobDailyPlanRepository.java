package com.example.api_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api_java.model.JobDailyPlan;

@Repository
public interface JobDailyPlanRepository extends JpaRepository<JobDailyPlan, String> {

    @Query("SELECT d FROM JobDailyPlan d WHERE d.jobWeeklyPlan.id IN :jobWeeklyPlanIds")
    List<JobDailyPlan> findByJobWeeklyPlanIdIn(@Param("jobWeeklyPlanIds") List<String> jobWeeklyPlanIds);
}
