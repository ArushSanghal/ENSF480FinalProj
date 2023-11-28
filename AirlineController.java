import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AirlineController {
    public static void main(String[] args) {
        // Get an instance of DatabaseConnection using the Singleton pattern
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

        // Call the method to get flight details
        List<String> flightDetailsList = databaseConnection.getFlightDetails();

        // Display the flight details
        for (String flightDetails : flightDetailsList) {
            System.out.println(flightDetails);
        }



    }
}


