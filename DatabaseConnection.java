import java.sql.*;
import java.util.*;

public class DatabaseConnection {
    // instance variables
    private Connection dbConnect;
    private ResultSet results;


/**
 * Constructs a new default DatabaseConnection object.
 */
    public DatabaseConnection() {

    }
    /**
     * Establishes a connection to the MySQL database with the specified URL, username, and password.
     */
    public void createConnection() {
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/ewr", "oop", "password");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}