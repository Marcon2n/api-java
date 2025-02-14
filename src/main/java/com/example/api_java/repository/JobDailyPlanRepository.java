package com.example.api_java.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api_java.model.JobDailyPlan;

@Repository
public interface JobDailyPlanRepository extends JpaRepository<JobDailyPlan, String> {
    @Query("SELECT d FROM JobDailyPlan d WHERE d.id = :id")
    Optional<JobDailyPlan> findJobDailyPlanById(@Param("id") String id);

    @Query("SELECT d FROM JobDailyPlan d WHERE d.jobWeeklyPlan.id = :jobWeeklyPlanId")
    List<JobDailyPlan> findByJobWeeklyPlanId(@Param("jobWeeklyPlanId") String jobWeeklyPlanId);

    @Query("SELECT d FROM JobDailyPlan d WHERE d.assignee = :assignee AND d.actionDate IN :actionDateRange")
    List<JobDailyPlan> findByAssigneeAndActionDateRange(
            @Param("assignee") String assignee,
            @Param("actionDateRange") List<String> actionDateRange);

    @Query("SELECT d FROM JobDailyPlan d WHERE d.assignee = :assignee AND d.actionDate = :actionDate")
    List<JobDailyPlan> findByAssigneeAndActionDate(
            @Param("assignee") String assignee,
            @Param("actionDate") String actionDate);
}
