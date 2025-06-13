package com.nj.notifications.customernotificationsystem.service;

import com.nj.notifications.customernotificationsystem.model.NotificationPreference;
import com.nj.notifications.customernotificationsystem.repository.NotificationPreferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationPreferenceService {

    private final NotificationPreferenceRepo repository;

    @Autowired
    public NotificationPreferenceService(NotificationPreferenceRepo repository) {
        this.repository = repository;
    }

    //gets notif preference by their username
    public Optional<NotificationPreference> getByUsername(String username) {
        return repository.findByUsername(username);
    }

    //saves or updates the notif preference in the db
    public NotificationPreference save(NotificationPreference preference) {
        return repository.save(preference);
    }

    //deletes the notif preference from the db
    public void deletePreference(Long id) {
        repository.deleteById(id);
    }
}