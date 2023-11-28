public class FlightPlan {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        databaseConnection.createConnection();


        // Example: Adding a new flight
        databaseConnection.addFlight("DOHA", "DUBAI", 300.00, "Aircraft16", "Crew16", 80, "2023-12-15", "14:30:00");

        databaseConnection.close();
    }
}
