package com.example.api_java.controller;

import com.example.api_java.dto.request.DailyReportUserDTO;
import com.example.api_java.dto.request.MapDataPairDTO;
import com.example.api_java.dto.request.UserWeekPlanDTO;
import com.example.api_java.dto.request.WeekReportAllUserDTO;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:2001")
public class UserController {

    @PostMapping("/weekly-plan/user")
    public UserWeekPlanDTO getWeekPlanByUser(@RequestBody Object request) {
        // TODO: process POST request
        System.out.println(request);
        return new UserWeekPlanDTO(null, null, null, null);
    }

    @PostMapping("/weekly-plan/result")
    public List<WeekReportAllUserDTO> getWeekReportUser(@RequestBody Object request) {
        // TODO: process POST request
        System.out.println(request);
        return List.of(new WeekReportAllUserDTO(null, null, null), new WeekReportAllUserDTO(null, null, null));
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
