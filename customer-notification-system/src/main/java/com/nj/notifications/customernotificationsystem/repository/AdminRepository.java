package com.nj.notifications.customernotificationsystem.repository;

import com.nj.notifications.customernotificationsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a WHERE a.username = :username")
    Optional<Admin> findByUsername(@Param("username") String username);

    @Query("SELECT a FROM Admin a WHERE a.email = :email")
    Optional<Admin> findByEmail(String email);

    @Query("SELECT a FROM Admin a WHERE a.username = :value OR a.email = :value")
    Optional<Admin> findByUsernameOrEmail(@Param("value") String value);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("SELECT a FROM Admin a WHERE a.role = :role")
    List<Admin> findByRole(Admin.Role role);
}