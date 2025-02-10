package com.example.api_java.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_java.model.JobWeeklyPlan;

@Repository
public interface JobWeeklyPlanRepository extends JpaRepository<JobWeeklyPlan, String> {
    Optional<List<JobWeeklyPlan>> findByAssigneeAndWeekAndMonthAndYear(String assignee, int week, int month, int year);
}
