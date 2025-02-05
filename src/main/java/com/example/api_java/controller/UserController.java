package com.example.api_java.controller;

import com.example.api_java.dto.request.DailyReportUser;
import com.example.api_java.dto.request.MapDataPair;
import com.example.api_java.dto.request.UserWeekPlan;
import com.example.api_java.dto.request.WeekReportAllUser;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("http://localhost:2001")
public class UserController {

    @PostMapping("/weekly-plan/user")
    public UserWeekPlan getWeekPlanByUser(@RequestBody Object request) {
        //TODO: process POST request
        System.out.println(request);
        return new UserWeekPlan(null, null, null, null);
    }

    @PostMapping("/weekly-plan/result")
    public List<WeekReportAllUser> getWeekReportUser(@RequestBody Object request) {
        //TODO: process POST request
        System.out.println(request);
        return List.of(new WeekReportAllUser(null, null, null), new WeekReportAllUser(null, null, null));
    }

    @PostMapping("/daily-plan/statistics")
    public DailyReportUser getDailyReportUser(@RequestBody Object request) {
        //TODO: process POST request
        System.out.println(request);
        return new DailyReportUser(null, null);
    }

    @PostMapping("/weekly-plan/daily-routing")
    public List<MapDataPair> getDayDistance(@RequestBody Object request) {
        //TODO: process POST request
        System.out.println(request);
        return List.of(new MapDataPair(null, null), new MapDataPair(null, null));
    }
}
