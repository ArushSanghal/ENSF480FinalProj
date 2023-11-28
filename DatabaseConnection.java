import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection dbConnect;
    private DatabaseConnection() {
    }
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public void createConnection() {
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/FLIGHTDATABASE", "oop", "password");
            dbConnect.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return dbConnect;
    }
    public void insertUser(String fullname, String email, String address, String passkey) {
        if (dbConnect == null) {
            System.out.println("Connection not established.");
            return;
        }
        try {
            Statement statement = dbConnect.createStatement();
            String query = String.format(
                "INSERT INTO users (Fullname, Email, Address, Passkey) VALUES ('%s', '%s', '%s', '%s')",
                fullname, email, address, passkey
            );
            statement.executeUpdate(query);
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    

   
    
        public ResultSet browseAirports(String cityName) {
            ResultSet resultSet = null;
            try {
                String query = "SELECT DISTINCT Origin, Destination FROM flights WHERE Origin = ? OR Destination = ?";
                try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query)) {
                    preparedStatement.setString(1, cityName);
                    preparedStatement.setString(2, cityName);
                    resultSet = preparedStatement.executeQuery();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }
    
        public ResultSet browseAircrafts(String aircraftNumber) {
            ResultSet resultSet = null;
            try {
                String query = "SELECT DISTINCT Aircraft FROM flights WHERE Aircraft = ?";
                try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query)) {
                    preparedStatement.setString(1, aircraftNumber);
                    resultSet = preparedStatement.executeQuery();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }
    
        public ResultSet browseUsers(String fullName, String email, String address) {
            ResultSet resultSet = null;
            try {
                String query = "SELECT Fullname, Email, Address FROM users WHERE Fullname = ? OR Email = ? OR Address = ?";
                try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query)) {
                    preparedStatement.setString(1, fullName);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, address);
                    resultSet = preparedStatement.executeQuery();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }
    
        public ResultSet browseAdmins(String username, int adminId) {
            ResultSet resultSet = null;
            try {
                String query = "SELECT Username, AdminID FROM admins WHERE Username = ? OR AdminID = ?";
                try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setInt(2, adminId);
                    resultSet = preparedStatement.executeQuery();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }
    
     
    
////////////////////////////////////////////////////////////////////////FOR EXTRACTION>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

public List<String> extractUserEmails() {
    List<String> emails = new ArrayList<>();

    try {
        String query = "SELECT Email FROM users";
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String email = resultSet.getString("Email");
                emails.add(email);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return emails;
}





public List<String> extractUserPasskeys() {
    List<String> passkeys = new ArrayList<>();

    try {
        String query = "SELECT Passkey FROM users";
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String passkey = resultSet.getString("Passkey");
                passkeys.add(passkey);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return passkeys;
}





public List<String> extractAdminUsernames() {
    List<String> usernames = new ArrayList<>();

    try {
        String query = "SELECT Username FROM admins";
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String username = resultSet.getString("Username");
                usernames.add(username);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return usernames;
}





public List<String> extractAdminPasswords() {
    List<String> adminPasswords = new ArrayList<>();

    try {
        String query = "SELECT AdminPass FROM admins";
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String adminPass = resultSet.getString("AdminPass");
                adminPasswords.add(adminPass);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return adminPasswords;
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////END OF EXTRACTION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\




///////////////////////ADDING FUCNTION FOR DISPLAYING FLIGHT DETAILS///////////////////////////////////////////////////////////////////////////////////


public List<String> getFlightDetails() {
    List<String> flightDetailsList = new ArrayList<>();

    try {
        String query = "SELECT Origin, Destination, SeatPrice, Maxseat, FlightDate, FlightTime FROM flights";
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String origin = resultSet.getString("Origin");
                String destination = resultSet.getString("Destination");
                double seatPrice = resultSet.getDouble("SeatPrice");
                int maxSeat = resultSet.getInt("Maxseat");
                Date flightDate = resultSet.getDate("FlightDate");
                Time flightTime = resultSet.getTime("FlightTime");

                String flightDetails = String.format("Origin: %s, Destination: %s, Seat Price: %.2f, Max Seats: %d, Flight Date: %s, Flight Time: %s",
                        origin, destination, seatPrice, maxSeat, flightDate, flightTime);

                flightDetailsList.add(flightDetails);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return flightDetailsList;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


































































































    public void insertPassengers(int FlightID, String PassengerName, int SeatNumber, int UserID) {
        if (dbConnect == null) {
            System.out.println("Connection not established.");
            return;
        }
        try {
            Statement statement = dbConnect.createStatement();
            String query = String.format(
                "INSERT INTO passengers (FlightID, PassengerName, SeatNumber, UserID) VALUES ('%d', '%s', '%d', '%d')",
                FlightID, PassengerName, SeatNumber, UserID
            );
            statement.executeUpdate(query);
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modifyFlightPlan(int flightID, String newOrigin, String newDestination) {
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(
                "UPDATE flights SET Origin = ?, Destination = ? WHERE FlightID = ?")) {
            preparedStatement.setString(1, newOrigin);
            preparedStatement.setString(2, newDestination);
            preparedStatement.setInt(3, flightID);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCrew(int flightID, String newCrew) {
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(
                "UPDATE flights SET Crew = ? WHERE FlightID = ?")) {
            preparedStatement.setString(1, newCrew);
            preparedStatement.setInt(2, flightID);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAircraft(int flightID, String newAircraft) {
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(
                "UPDATE flights SET Aircraft = ? WHERE FlightID = ?")) {
            preparedStatement.setString(1, newAircraft);
            preparedStatement.setInt(2, flightID);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            if (dbConnect != null) {
                dbConnect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}