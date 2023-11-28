import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void selectCrew(int flightID, String crewName, int CrewNumber) {
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(
                "UPDATE flights SET Crew = ?, CrewNumber = ? WHERE FlightID = ?")) {
            preparedStatement.setString(1, crewName);
            preparedStatement.setInt(2, CrewNumber);
            preparedStatement.setInt(3, flightID);
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

    public void addFlight(int flightID, String origin, String destination, String crew, String aircraft) {
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(
                "INSERT INTO flights (FlightID, Origin, Destination, CrewID, Aircraft) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, flightID);
            preparedStatement.setString(2, origin);
            preparedStatement.setString(3, destination);
            preparedStatement.setString(4, crew);
            preparedStatement.setString(5, aircraft);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFlight(int flightID) {
        try (PreparedStatement preparedStatement = dbConnect.prepareStatement(
                "DELETE FROM flights WHERE FlightID = ?")) {
            preparedStatement.setInt(1, flightID);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFlightCrew(int flightID, String newCrew) {
        if (dbConnect == null) {
            System.out.println("Connection not established.");
            return;
        }

        try {
            PreparedStatement preparedStatement = dbConnect.prepareStatement(
                    "UPDATE flights SET CrewID = ? WHERE FlightID = ?");
            preparedStatement.setString(1, newCrew);
            preparedStatement.setInt(2, flightID);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFlightOrigin(int flightID, String newOrigin) {
        if (dbConnect == null) {
            System.out.println("Connection not established.");
            return;
        }

        try {
            PreparedStatement preparedStatement = dbConnect.prepareStatement(
                    "UPDATE flights SET Origin = ? WHERE FlightID = ?");
            preparedStatement.setString(1, newOrigin);
            preparedStatement.setInt(2, flightID);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFlightDestination(int flightID, String newDestination) {
        if (dbConnect == null) {
            System.out.println("Connection not established.");
            return;
        }

        try {
            PreparedStatement preparedStatement = dbConnect.prepareStatement(
                    "UPDATE flights SET Destination = ? WHERE FlightID = ?");
            preparedStatement.setString(1, newDestination);
            preparedStatement.setInt(2, flightID);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFlightSeatPrice(int flightID, double newSeatPrice) {
        if (dbConnect == null) {
            System.out.println("Connection not established.");
            return;
        }

        try {
            PreparedStatement preparedStatement = dbConnect.prepareStatement(
                    "UPDATE flights SET SeatPrice = ? WHERE FlightID = ?");
            preparedStatement.setDouble(1, newSeatPrice);
            preparedStatement.setInt(2, flightID);
            preparedStatement.executeUpdate();
            dbConnect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFlight(int flightID, String attribute, String newValue) {
        switch (attribute.toLowerCase()) {
            case "origin":
                updateFlightOrigin(flightID, newValue);
                break;
            case "destination":
                updateFlightDestination(flightID, newValue);
                break;
            case "seatprice":
                updateFlightSeatPrice(flightID, Double.parseDouble(newValue));
                break;
            default:
                System.out.println("Invalid attribute.");
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
