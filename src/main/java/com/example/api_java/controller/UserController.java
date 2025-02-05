package com.example.api_java.controller;

import com.example.api_java.dto.request.DailyTask;
import com.example.api_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("http://localhost:2001")
public class UserController {

    @PostMapping("/weekly-plan/user")
    public DailyTask postMethodName(@RequestBody Object request) {
        //TODO: process POST request
        System.out.println(request);
        return new DailyTask(null, null, null, null);
    }
    
}
