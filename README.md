# Notification-Address-Facade-System 2.0

## Overview
The Customer Notification Address Facade System is designed to manage customer contact information with their notification preferences. It acts as the go-to place for recipient addresses and delivery statuses, making it easy for other systems to fetch and update customer delivery info efficiently.

## Features

### User Management
- Admin Authentication: Secure login for admin and user roles with Spring Security and role-based access control.
- Pre-configured Users (in data.sql):
  - Admin: username: "superadmin" and password: "admin123"
  - User: username: "user" and password: "user123"

### Customer Management
- CRUD Operations: Add, edit, view, and delete customers through a web-based admin dashboard.
- Customer Details: Stores full name, email, phone number, status, and notification preferences (email, SMS).
- Customer List: Displays all customers in a table with their details.
- Add Customer: Dedicated page in the customer list for adding new customers.
- Edit/Delete: Inline editing and deletion of customers via the customer list UI.

### Preference Management
- Notification Preferences: Configure email and SMS notification preferences using checkboxes.
- Update Preferences: Modify preferences during customer creation or editing.
- Display Preferences: Shows current preferences in the customer list table.

### Integration API
- RESTful API: Endpoints at /api/customers for managing customers.
- Secure API Access: Requires authentication with ADMIN or USER roles for all API operations.

### Database
- Using MySQL.
- Using two tables: admins and customers.

### Usage
1. Clone the Repository.
2. Open project in Intellij/Eclipse.
3. Run the project via Spring Boot.
4. Open http://localhost:8080 in your browser.
5. Log in using the credentials mentioned above.

### Directory structure
src/main/java/com/nj/notifications/customernotificationsystem/
-- config/
  -- SecurityConfig.java
-- controller/
  -- ApiController.java
  -- LoginController.java
  -- AdminController.java
-- model/
  -- Admin
  -- Customer
-- service/
  -- AdminService
  -- CustomerService
  -- CustomUserDetailsService
-- repository/
  -- AdminRepository
  -- CustomerRepository

src/main/resources/
-- templates/
  -- admin/
    -- customerList.html
    -- dashboard.html
    -- register.html
    -- registerUser.html
  -- customer/
    -- add.html    //empty
    -- edit.html   //empty
    -- list.html   //empty
    -- dashboard.html
  -- login.html
-- static/
-- applicationProperties









