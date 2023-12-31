DROP DATABASE IF EXISTS FLIGHTDATABASE;
CREATE DATABASE FLIGHTDATABASE; 
USE FLIGHTDATABASE;

CREATE TABLE flights (
    FlightID INT AUTO_INCREMENT PRIMARY KEY,
    Origin VARCHAR(50) NOT NULL,
    Destination VARCHAR(50) NOT NULL,
    SeatPrice DECIMAL(10, 2) NOT NULL,
    Aircraft VARCHAR(50) NOT NULL,
    Crew VARCHAR(50) NOT NULL,
    Maxseat INT
);

CREATE TABLE users (
    Fullname VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Address VARCHAR(50) NOT NULL,
    Passkey VARCHAR(50) NOT NULL
);

CREATE TABLE admins (
	Username VARCHAR(50) NOT NULL,
    AdminID INT, 
    AdminPass VARCHAR(50) NOT NULL
);

INSERT INTO admins (Username, AdminID, AdminPass)
VALUES
    ('joe_3', 2687, 'joeonly'),
	('ronair', 2769, 'flyaway'),
    ('davidson5', 2841, 'restricted');

INSERT INTO users (Fullname, Email, Address)
VALUES
    ('John Doe', 'johndoe2@gmail.com', '3214 Ave, T2N 4V2', 'secretpassword'),
    ('Steve Jobs', 'steveiscool@yahoo.com', '12th Street, T1N 5V7','apple'),
    ('James Smith', 'jsmith1@yahoo.com', '8425 Ave NW, T9S 4V5','jsmith'),
    ('Thomas Brown', 'thomasbrown@gmail.com', '120 Bremner Blvd, M5J 0A8','brownthomas');
    
    

INSERT INTO flights (Origin, Destination, SeatPrice, Aircraft, Crew, Maxseat)
VALUES
    ('Calgary', 'Edmonton', 100.00, 'Aircraft1', 'Crew1', 75),
    ('Calgary', 'Vancouver', 200.00, 'Aircraft2', 'Crew2', 60),
    ('Edmonton', 'Montreal', 250.00, 'Aircraft3', 'Crew3', 80),
    ('Ottawa', 'Quebec City', 125.00, 'Aircraft4', 'Crew4', 75),
    ('Saskatoon', 'Toronto', 350.00, 'Aircraft5', 'Crew5', 100),
    ('Toronto', 'Vancouver', 400.00, 'Aircraft6', 'Crew6', 95),
    ('Vancouver', 'Toronto', 425.00, 'Aircraft7', 'Crew7', 90),
    ('Calgary', 'Toronto', 425.00, 'Aircraft8', 'Crew8', 85),
    ('Winnipeg', 'Edmonton', 225.00, 'Aircraft9', 'Crew9', 55),
    ('Montreal', 'Vancouver', 335.00, 'Aircraft10', 'Crew10', 70),
    ('Vancouver', 'Charlottetown', 435.00, 'Aircraft11', 'Crew11', 65),
    ('Charlottetown', 'Toronto', 250.00, 'Aircraft12', 'Crew12', 50),
    ('Montreal', 'Calgary', 275.00, 'Aircraft13', 'Crew13', 95),
    ('Edmonton', 'Calgary', 125.00, 'Aircraft14', 'Crew14', 75),
    ('Winnipeg', 'Toronto', 250.00, 'Aircraft15', 'Crew15', 100);
    