public class AdminController {

    private DatabaseConnection dbConnection;

    public AdminController() {
        dbConnection = DatabaseConnection.getInstance();
    }

    public void modifyFlightPlan(int flightID, String newOrigin, String newDestination) {
        dbConnection.modifyFlightPlan(flightID, newOrigin, newDestination);
    }

    public void selectCrew(int flightID, String newCrew) {
        dbConnection.selectCrew(flightID, newCrew);
    }

    public void selectAircraft(int flightID, String newAircraft) {
        dbConnection.selectAircraft(flightID, newAircraft);
    }
}
