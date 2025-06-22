CREATE DATABASE IF NOT EXISTS notification_system;
USE notification_system;

DROP TABLE IF EXISTS notification_preferences;
DROP TABLE IF EXISTS notifications;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS admins;

CREATE TABLE admins (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(15) NOT NULL UNIQUE,
                        password VARCHAR(200) NOT NULL,
                        email VARCHAR(100) NOT NULL UNIQUE,
                        full_name VARCHAR(100) NOT NULL,
                        role ENUM('ADMIN', 'USER') NOT NULL DEFAULT 'ADMIN',
                        is_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE customers (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        email VARCHAR(100) NOT NULL UNIQUE,
                        phone_number VARCHAR(20),
                        notif_preference  VARCHAR(10)
);