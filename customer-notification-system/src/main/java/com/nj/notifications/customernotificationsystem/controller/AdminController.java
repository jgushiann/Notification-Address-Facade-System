package com.nj.notifications.customernotificationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private InMemoryUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //enters the registration page for admins
    @GetMapping("/register")
    public String showRegisterForm() {
        return "admin/register";
    }

    //handles submission when an admin registers on the page
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        UserDetails newUser = User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles("ADMIN")
                .build();
        userDetailsManager.createUser(newUser);
        return "redirect:/login";
    }
}