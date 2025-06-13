package com.nj.notifications.customernotificationsystem.repository;

import com.nj.notifications.customernotificationsystem.model.NotificationPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//repo to handle database stuff for NotificationPreference
public interface NotificationPreferenceRepo extends JpaRepository<NotificationPreference, Long> {
    Optional<NotificationPreference> findByUsername(String username);
}