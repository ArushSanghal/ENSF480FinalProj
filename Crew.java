import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crew {

    private String role;

    public Crew(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void browsePassengers(int flightID) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnection.getConnection();
            String query = "SELECT PassengerName, SeatNumber FROM passengers WHERE FlightID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, flightID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String passengerName = resultSet.getString("PassengerName");
                int seatNumber = resultSet.getInt("SeatNumber");

                System.out.println("Passenger: " + passengerName + ", Seat Number: " + seatNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeResources(resultSet, preparedStatement, connection);
        }
    }

}
