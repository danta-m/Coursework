DROP DATABASE Coursework;

CREATE DATABASE Coursework;
USE Coursework;

CREATE TABLE Profile (
id BIGINT NOT NULL AUTO_INCREMENT,
firstName VARCHAR(100) NOT NULL,
lastName VARCHAR(100) NOT NULL,
email VARCHAR(50) NOT NULL,
phoneNumber VARCHAR(13) NOT NULL,
postalCode VARCHAR(5) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE Service (
id BIGINT NOT NULL AUTO_INCREMENT,
serviceName VARCHAR(50) NOT NULL,
isActive BOOL NOT NULL,
serviceMonthPrice DOUBLE NOT NULL,
customerId INT NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE User_role (
id BIGINT NOT NULL AUTO_INCREMENT,
role_name VARCHAR(50) NOT NULL,
role_description VARCHAR(500) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE User (
id BIGINT NOT NULL AUTO_INCREMENT,
user_name VARCHAR(50) NOT NULL,
password VARCHAR(20) NOT NULL,
user_role_id BIGINT NOT NULL,
profile_id BIGINT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(profile_id) references Profile (id),
FOREIGN KEY(user_role_id) references User_role(id)
);

CREATE TABLE User_services (
service_id BIGINT NOT NULL,
user_id BIGINT NOT NULL,
FOREIGN KEY(service_id) references Service(id),
FOREIGN KEY(user_id) references User(id)
);

CREATE TABLE Incident (
id BIGINT NOT NULL AUTO_INCREMENT,
serviceName VARCHAR(50) NOT NULL,
isActive BOOL,
problemDescription VARCHAR(500) NOT NULL,
user_id BIGINT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(user_id) references User(id)
);

INSERT INTO Profile
(firstName, lastName, email, phoneNumber, postalCode)
VALUES
('Lesia', 'Kurt', 'lesia@gmail.com', '095-000-05-05', '04000'),
('Pol', 'Anderson', 'polan@gmail.com', '093-000-03-03', '04001'),
('Cassady', 'Kim', 'cassy@gmail.com', '096-000-06-06', '04002'),
('Jackie', 'Brown', 'jack@gmail,com', '097-000-07-07', '04003'),
('Mike', 'Loson', 'mikelos@gmail.com', '067-000-67-67', '04004');

INSERT INTO Service 
(serviceName, isActive, serviceMonthPrice, customerId) 
VALUES 
('allRights', true, 0, 001),
('allRights', true, 0, 002),
('premium', true, 199.99, 101),
('standart', true, 99.99, 102),
('standart', false, 99.99, 103);

INSERT INTO User_role
(role_name, role_description) 
VALUES
('SUPER_ADMIN', 'all rights'),
('ADMIN', 'limited rights'),
('USER', 'player rights'),
('USER', 'player rights'),
('USER',  'player rights');

INSERT INTO User
(user_name, password, user_role_id, profile_id)
VALUES
('headshot', 'superadmin', 1, 1),
('chief', 'admin', 2, 2),
('pandora', 'user1', 3, 3),
('boo', 'user2', 4, 4),
('jazz', 'user3', 5, 5);

INSERT INTO Incident 
(serviceName, isActive, problemDescription, user_id)
VALUES
('error404', true, 'subscription ended', 5),
('error400', true, 'error in payment', 5);

SELECT *
FROM USER;

SELECT * FROM User_role
INNER JOIN Profile
ON User_role.id = Profile.id AND role_name = 'USER';

SELECT * FROM User_role
INNER JOIN User
ON User_role.id = User.id AND role_name = 'USER';