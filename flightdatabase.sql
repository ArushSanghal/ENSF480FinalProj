DROP DATABASE IF EXISTS FLIGHTDATABASE;
CREATE DATABASE FLIGHTDATABASE; 
USE FLIGHTDATABASE;

CREATE TABLE crew (
    CrewID INT AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) NOT NULL,
    Pass VARCHAR(50) NOT NULL,
    CrewName VARCHAR(50) NOT NULL,
    CrewRole VARCHAR(50) NOT NULL,
    CrewNumber INT NOT NULL
);

CREATE TABLE flights (
    FlightID INT AUTO_INCREMENT PRIMARY KEY,
    Origin VARCHAR(50) NOT NULL,
    Destination VARCHAR(50) NOT NULL,
    SeatPrice DECIMAL(10, 2) DEFAULT 100.00,
    Aircraft VARCHAR(50) NOT NULL,
    CrewID INT NOT NULL,
    Maxseat INT,
    FlightDate DATE NOT NULL,
    FlightTime TIME NOT NULL,
    FOREIGN KEY (CrewID) REFERENCES crew (CrewID)
);

CREATE TABLE users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
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

CREATE TABLE passengers (
    PassengerID INT AUTO_INCREMENT PRIMARY KEY,
    FlightID INT,
    PassengerName VARCHAR(50),
    SeatNumber INT,
    UserID INT,
    FOREIGN KEY (FlightID) REFERENCES flights(FlightID),
    FOREIGN KEY (UserID) REFERENCES users(UserID)
);

INSERT INTO crew (Email, Pass, CrewName, CrewRole, CrewNumber)
VALUES
	('johnwi@gmail.com', 'john143','John Williams', 'Pilot', 7),
    ('', '', '', 'Flight Attendant', 1),
    ('', '', '', 'Co-Pilot', 1),
	('', '', '','Pilot', 2),
    ('', '', '', 'Flight Attendant', 2),
    ('', '', '', 'Co-Pilot', 2),
    ('', '', '', 'Pilot', 3),
    ('', '', '', 'Flight Attendant', 3),
    ('', '', '', 'Co-Pilot', 3),
    ('', '', '', 'Pilot', 4),
    ('', '', '', 'Flight Attendant', 4),
    ('', '', '', 'Co-Pilot', 4),
    ('', '', '', 'Pilot', 5),
    ('', '', '', 'Flight Attendant', 5),
    ('', '', '', 'Co-Pilot', 5),
    ('', '', '', 'Pilot', 6),
    ('', '', '', 'Flight Attendant', 6),
    ('', '', '', 'Co-Pilot', 6),
    ('', '', '', 'Pilot', 7),
    ('', '', '', 'Flight Attendant', 7),
    ('', '', '', 'Co-Pilot', 7);
    
INSERT INTO admins (Username, AdminID, AdminPass)
VALUES
    ('joe_3', 2687, 'joeonly'),
	('ronair', 2769, 'flyaway'),
    ('davidson5', 2841, 'restricted');

INSERT INTO users (Fullname, Email, Address, Passkey)
VALUES
    ('John Doe', 'johndoe2@gmail.com', '3214 Ave, T2N 4V2', 'secretpassword'),
    ('Steve Jobs', 'steveiscool@yahoo.com', '12th Street, T1N 5V7','apple'),
    ('James Smith', 'jsmith1@yahoo.com', '8425 Ave NW, T9S 4V5','jsmith'),
    ('Thomas Brown', 'thomasbrown@gmail.com', '120 Bremner Blvd, M5J 0A8','brownthomas');
    

INSERT INTO flights (Origin, Destination, SeatPrice, Aircraft, CrewID, Maxseat, FlightDate, FlightTime)
VALUES
    ('Calgary', 'Edmonton', 100.00, 'Aircraft1', '1', 75, '2023-12-02', '12:30:00'),
    ('Calgary', 'Vancouver', 200.00, 'Aircraft2', '2', 60, '2023-12-04', '12:35:00'),
     ('Edmonton', 'Montreal', 250.00, 'Aircraft3', '3', 80,'2023-12-01','17:05:00'),
    ('Ottawa', 'Quebec City', 125.00, 'Aircraft4', '4', 75,'2023-12-07', '14:00:00'),
    ('Saskatoon', 'Toronto', 350.00, 'Aircraft5', '5', 100,'2023-12-22', '13:00:00'),
    ('Toronto', 'Vancouver', 400.00, 'Aircraft6', '6', 95, '2023-12-18', '19:00:00'),
    ('Vancouver', 'Toronto', 425.00, 'Aircraft7', '7', 90, '2023-12-10', '11:00:00'),
    ('Calgary', 'Toronto', 425.00, 'Aircraft8', '8', 85, '2023-12-09', '15:30:00'),
    ('Winnipeg', 'Edmonton', 225.00, 'Aircraft9', '9', 55,'2023-12-27', '18:45:00'),
    ('Montreal', 'Vancouver', 335.00, 'Aircraft10', '10', 70, '2024-01-01', "00:00:00"),
    ('Vancouver', 'Charlottetown', 435.00, 'Aircraft11', '11', 65,'2023-12-21', '16:00:00'),
    ('Charlottetown', 'Toronto', 250.00, 'Aircraft12', '12', 50,'2023-12-25', '20:00:00'),
    ('Montreal', 'Calgary', 275.00, 'Aircraft13', '13', 95,'2023-12-12', '12:12:00'),
    ('Edmonton', 'Calgary', 125.00, 'Aircraft14', '14', 75,'2023-12-05', '10:10:00'),
    ('Winnipeg', 'Toronto', 250.00, 'Aircraft15', '15', 100,'2023-12-03', '09:00:00');