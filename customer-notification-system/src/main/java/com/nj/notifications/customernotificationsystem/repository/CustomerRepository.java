package com.nj.notifications.customernotificationsystem.repository;

import com.nj.notifications.customernotificationsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//repo for doing database stuff with Customer entities (saving, finding...)
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}