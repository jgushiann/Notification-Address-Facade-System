package com.nj.notifications.customernotificationsystem.service;

import com.nj.notifications.customernotificationsystem.model.Admin;
import com.nj.notifications.customernotificationsystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    //loads admin user details for authentication based on username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with this username: " + username));

        if (!admin.isActive()) {
            throw new UsernameNotFoundException("Account is disabled for user: " + username);
        }
        return admin;
    }
}