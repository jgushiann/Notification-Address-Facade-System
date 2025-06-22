# Notification-Address-Facade-SystemMore actions
## Overview
The Customer Notification Address Facade System is designed to manage customer contact information with their notification preferences. It acts as the go-to place for recipient addresses and delivery statuses, making it easy for other systems to fetch and update customer delivery info efficiently.

## Features

### User Management
 - Admin authentication: Secure login for admin users with role-based access control.
 - Pre-configured users: Admin (username: admin, password: admin123) and user (username: user, password: user123) accounts for demo version...

### Customer Management
 - CRUD operations: add, edit and view customers via a web UI
 - Customer details: stores name, email, phone number and customer's notification preferences
 - Customer list: displays all customers with their notification preferences 

### Preference Management
 - Notification preferences: save customer preferences (Email, SMS, WEB Notification)
 - Update preferences: modify preferences when adding or editing customers
 - Display preferences: show current preferences in the customer list

### Integration and API
 - RESTful API: endpoints at /api/customers for customer management (GET, POST, PUT)
 - Secure API access: requires admin authentication for all API operations\

### Database 
 - Uses an in-memory H2 database, auto-created at startup


## Set up
 - Clone the repository
 - Build the project
 - Run the application

## Usage
When you run the application:
1. open http://localhost:8080 (while running) in the browser.
2. Log in :
    - Admin: Username - "admin", password - "admin123"
    - User: Username - "user", password - "user123"
3. After logging in, you can add, edit, and view customers with notification preferences via the admin dashboard.


### Directory Structure

-src/main/java/com/nj/notifications/customernotificationsystem/
  -config/: SecurityConfig.java
  -controller/: HomeController.java, LoginController.java, CustomerController.java, AdminController.java, NotificationPreferenceController.java
  -model/: Customer.java, NotificationPreference.java
  -service/: CustomerService.java, NotificationPreferenceService.java
  -repository/: CustomerRepo.java, NotificationPreferenceRepo.java

-src/main/resources/
  -templates/: Thymeleaf templates (admin/dashboard.html, customers/list.html...)
  -static/: Static files (index.html)
  -application.properties: Configuration settings

-src/test/java/com/nj/notifications/customernotificationsystem/
  -ServiceTest.java.
  -ControllerTest.java.
  -ConfigTest.java.
 - src/main/java/com/nj/notifications/customernotificationsystem/
   - config/: SecurityConfig.java
   - controller/: HomeController.java, LoginController.java, CustomerController.java, AdminController.java, NotificationPreferenceController.java
   - model/: Customer.java, NotificationPreference.java
   - service/: CustomerService.java, NotificationPreferenceService.java
   - repository/: CustomerRepo.java, NotificationPreferenceRepo.java

 - src/main/resources/
   - templates/: Thymeleaf templates (admin/dashboard.html, customers/list.html...)
   - static/: Static files (index.html)
   - application.properties: Configuration settings

 - src/test/java/com/nj/notifications/customernotificationsystem/
   - ServiceTest.java.
   - ControllerTest.java.
   - ConfigTest.java.


### Notes (All for the demo purposes...)
 - Security: CSRF is disabled 
 - Database: In-memory H2 database
 - Gaps: Lacks address management, notification tracking, search/filtering, and reporting features due to some reasons


### Future Improvements
 - Add address management and advanced search
 - Improve UI
 - Include reporting for notification preferences
 - Implement notification sending

