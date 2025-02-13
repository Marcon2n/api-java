package com.example.api_java.controller;

import com.example.api_java.dto.request.DailyReportUserDTO;
import com.example.api_java.dto.request.MapDataPairDTO;
import com.example.api_java.dto.request.UserWeekPlanDTO;
import com.example.api_java.dto.request.UserWeekPlanRequestDTO;
import com.example.api_java.dto.request.WeekReportAllUserDTO;
import com.example.api_java.service.JobPlanService;
import com.example.api_java.service.JobWeekReportAllUser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:2001")
public class UserController {

    @Autowired
    private JobPlanService jobPlanService;

    @Autowired
    private JobWeekReportAllUser jobWeekReportAllUser;

    @PostMapping("/weekly-plan/user")
    public Optional<UserWeekPlanDTO> getWeekPlanByUser(@RequestBody UserWeekPlanRequestDTO request) {
        // TODO: process POST request
        System.out.println(request);
        // return new UserWeekPlanDTO(null, null, null, null);
        return jobPlanService.getJobPlan(request);
    }

    @PostMapping("/weekly-plan/result")
    public Optional<List<WeekReportAllUserDTO>> getWeekReportUser(@RequestBody UserWeekPlanRequestDTO request) {
        // TODO: process POST request
        System.out.println(request);
        // return List.of(new WeekReportAllUserDTO(null, null, null), new
        // WeekReportAllUserDTO(null, null, null));
        return jobWeekReportAllUser.getWeekReportAllUser(request);
    }

    @PostMapping("/daily-plan/statistics")
    public DailyReportUserDTO getDailyReportUser(@RequestBody Object request) {
        // TODO: process POST request
        System.out.println(request);
        return new DailyReportUserDTO(null, null);
    }

    @PostMapping("/weekly-plan/daily-routing")
    public List<MapDataPairDTO> getDayDistance(@RequestBody Object request) {
        // TODO: process POST request
        System.out.println(request);
        return List.of(new MapDataPairDTO(null, null), new MapDataPairDTO(null, null));
    }
}
