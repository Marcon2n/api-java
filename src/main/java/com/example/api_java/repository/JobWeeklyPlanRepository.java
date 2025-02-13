package com.example.api_java.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api_java.model.JobWeeklyPlan;

@Repository
public interface JobWeeklyPlanRepository extends JpaRepository<JobWeeklyPlan, String> {
    @Query("SELECT j FROM JobWeeklyPlan j WHERE j.week = :week AND j.month = :month AND j.year = :year")
    Optional<List<JobWeeklyPlan>> findWeeklyReportAllUser(
            @Param("week") int week,
            @Param("month") int month,
            @Param("year") int year);

    Optional<JobWeeklyPlan> findByAssigneeAndWeekAndMonthAndYear(String assignee, int week, int month, int year);
}
