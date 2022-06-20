package com.msa.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController{

    @GetMapping("/{target-id}")
    public String sendNotification(@PathVariable("target-id") String targetId, @RequestParam("target-type") String targetType){
        return "Welcome " + targetType + " - " + targetId+", Nice to meet you";
    }
}
