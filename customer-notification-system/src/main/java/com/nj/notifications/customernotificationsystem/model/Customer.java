package com.nj.notifications.customernotificationsystem.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String notificationPreference;

    //returns customer's id
    public Long getId() {
        return id;
    }

    //receives and sets the customer id
    public void setId(Long id) {
        this.id = id;
    }

    //returns the customer's name
    public String getName() {
        return name;
    }

    //receives and sets the customer's name
    public void setName(String name) {
        this.name = name;
    }

    //returns customer's email
    public String getEmail() {
        return email;
    }

    //receives and sets the customer's email
    public void setEmail(String email) {
        this.email = email;
    }

    //returns the customer's phone number as a string
    public String getPhone() {
        return phone;
    }

    //receives and sets the customer's phone number
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //returns customer's notif preferencies
    public String getNotificationPreference() {
        return notificationPreference;
    }

    //receives and sets the customer's notif preferencies
    public void setNotificationPreference(String notificationPreference) {
        this.notificationPreference = notificationPreference;
    }
}