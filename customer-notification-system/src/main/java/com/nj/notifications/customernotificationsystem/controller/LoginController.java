package com.nj.notifications.customernotificationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    //shows the login page when the user goes to /login
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
