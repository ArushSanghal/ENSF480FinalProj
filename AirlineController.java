import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AirlineController {



    private static void processResultSet(ResultSet resultSet, String resultType) {
        try {
            System.out.println(resultType + ":");
            while (resultSet.next()) {
                if (resultType.contains("Aircraft")) {
                    System.out.println("Aircraft: " + resultSet.getString("Aircraft"));
                } else if (resultType.contains("Airport")) {
                    System.out.println("Origin: " + resultSet.getString("Origin") +
                                       ", Destination: " + resultSet.getString("Destination"));
                } else {
                    System.out.println("Username: " + resultSet.getString("Username"));
                    System.out.println("AdminID: " + resultSet.getInt("AdminID"));
                }
            }
            System.out.println("-----------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();


        List<String> flightDetailsList = databaseConnection.getFlightDetails();

        for (String flightDetails : flightDetailsList) {
            System.out.println(flightDetails);
        }


        ResultSet allAirportsResultSet = databaseConnection.browseAllAirports();
        processResultSet(allAirportsResultSet, "All Airport Results");

        ResultSet allAircraftsResultSet = databaseConnection.browseAllAircrafts();
        processResultSet(allAircraftsResultSet, "All Aircraft Results");

        ResultSet allUsersResultSet = databaseConnection.browseAllUsers();
        processResultSet(allUsersResultSet, "All User Results");

        ResultSet allAdminsResultSet = databaseConnection.browseAllAdmins();
        processResultSet(allAdminsResultSet, "All Admin Results");



        
    }



    }



