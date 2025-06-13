package com.nj.notifications.customernotificationsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//I created this controller at the beginning just to test if the server was running or not
@RestController
public class TestController {
    @GetMapping("/test")
    public String ping() {
        return "works";
    }
}
