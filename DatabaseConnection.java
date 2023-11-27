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
