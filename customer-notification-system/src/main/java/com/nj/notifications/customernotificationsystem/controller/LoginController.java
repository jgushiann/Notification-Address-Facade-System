package com.nj.notifications.customernotificationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//handles showing the custom login page automatically
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String Login() {
        return "login";
    }

    @GetMapping("/admin/logout")
    public String logout() {
        return "login";
    }
}
