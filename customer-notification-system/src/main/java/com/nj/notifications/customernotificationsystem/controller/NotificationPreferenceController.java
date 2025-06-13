package com.nj.notifications.customernotificationsystem.controller;

import com.nj.notifications.customernotificationsystem.model.NotificationPreference;
import com.nj.notifications.customernotificationsystem.service.NotificationPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/preferences")
public class NotificationPreferenceController {

    private final NotificationPreferenceService preferenceService;

    //constructor
    @Autowired
    public NotificationPreferenceController(NotificationPreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    //gets the notification preferencies for the given customer
    @GetMapping("/{username}")
    public ResponseEntity<NotificationPreference> getPreferences(@PathVariable String username) {
        Optional<NotificationPreference> pref = preferenceService.getByUsername(username);
        return pref.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //saves (or updates) the notification preferences
    @PostMapping
    public ResponseEntity<NotificationPreference> savePreferences(@RequestBody NotificationPreference preference) {
        NotificationPreference savedPref = preferenceService.save(preference);
        return ResponseEntity.ok(savedPref);
    }

    //deletes the notification preferencies
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreferences(@PathVariable Long id) {
        preferenceService.deletePreference(id);
        return ResponseEntity.noContent().build();
    }
}