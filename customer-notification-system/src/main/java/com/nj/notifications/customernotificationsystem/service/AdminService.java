package com.nj.notifications.customernotificationsystem.service;

import com.nj.notifications.customernotificationsystem.model.Admin;
import com.nj.notifications.customernotificationsystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //registers a new admin after checkign username and email uniqueness
    public Admin registerAdmin(Admin admin) throws Exception {
        if (adminRepository.existsByUsername(admin.getUsername())) {
            throw new Exception("Username already exists");
        }
        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new Exception("Email is already registered");
        }
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

}