package com.nj.notifications.customernotificationsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NotificationPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private boolean email;
    private boolean sms;
    private boolean inApp;

    //default constructor
    public NotificationPreference() {}

    //initializing
    public NotificationPreference(String username) {
        this.email = true;
        this.sms = true;
        this.inApp = true;
        this.username = username;
    }

    //returns id
    public Long getId() {
        return this.id;
    }

    //receives and sets the id
    public void setId(Long id) {
        this.id = id;
    }

    //returns the username
    public String getUsername() {
        return this.username;
    }

    //receives and sets the username
    public void setUsername(String username) {
        this.username = username;
    }

    //checks if the email notifs are enabled
    public boolean isEmail() {
        return this.email;
    }

    //updates email notif preference
    public void setEmail(boolean email) {
        this.email = email;
    }

    //checks if the sms notifs are enabled
    public boolean isSms() {
        return this.sms;
    }

    //updates sms notif preference
    public void setSms(boolean sms) {
        this.sms = sms;
    }

    //checks if the web notifs are enabled
    public boolean isInApp() {
        return this.inApp;
    }

    //updates web notif preference
    public void setInApp(boolean inApp) {
        this.inApp = inApp;
    }

    //returns the preferred notif method based on whats enabled (email sms or web)
    public String getPreferredMethod() {
        String preference = "Unknown";

        if(isEmail())  preference = "EMAIL";
        else if(isSms()) preference = "SMS";
        else if(isInApp()) preference = "WEB";

        return preference;
    }
}
