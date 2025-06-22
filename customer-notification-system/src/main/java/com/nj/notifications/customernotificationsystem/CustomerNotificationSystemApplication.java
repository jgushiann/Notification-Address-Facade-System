package com.nj.notifications.customernotificationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class CustomerNotificationSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerNotificationSystemApplication.class, args);

    }

}
