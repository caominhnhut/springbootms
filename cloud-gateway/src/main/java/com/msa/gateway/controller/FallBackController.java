package com.msa.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController{

    @GetMapping("/user-fallback")
    public String userFallBack(){
        return "Something wrong with user service";
    }

    @GetMapping("/department-fallback")
    public String departmentFallBack(){
        return "Something wrong with department service";
    }

    @GetMapping("/notification-fallback")
    public String notificationFallBack(){
        return "Something wrong with notification service";
    }

}
