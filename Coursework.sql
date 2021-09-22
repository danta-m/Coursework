CREATE DATABASE Coursework;
USE Coursework;

CREATE TABLE Profile (
    id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phoneNumber VARCHAR(13) NOT NULL,
    postalCode VARCHAR(5) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Service (
    id INT NOT NULL AUTO_INCREMENT,
    serviceName VARCHAR(50) NOT NULL,
    isActive BOOL NOT NULL,
    serviceMonthPrice DOUBLE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE User_role (
    id INT NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(50) NOT NULL,
    role_description VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE User (
    id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(20) NOT NULL,
    user_role_id INT NOT NULL,
    profile_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(profile_id) references Profile (id),
    FOREIGN KEY(user_role_id) references User_role(id)
);

CREATE TABLE User_services (
    service_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY(service_id) references Service(id),
    FOREIGN KEY(user_id) references User(id)
);

CREATE TABLE Incident (
    id INT NOT NULL AUTO_INCREMENT,
    serviceName VARCHAR(50) NOT NULL,
    isActive BOOL,
    problemDescription VARCHAR(500) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(user_id) references User(id)
);