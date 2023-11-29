public class AdminController {

    private DatabaseConnection dbConnection;

    public AdminController() {
        dbConnection = DatabaseConnection.getInstance();
    }

    public void selectCrew(String newCrew,  int CrewNumber) {
        dbConnection.selectCrew(newCrew, CrewNumber);
    }

    public void updateAircraft(int flightID, String newAircraft) {
        dbConnection.updateAircraft(flightID, newAircraft);
    }

    public void modifyFlightPlan(int flightID, String attribute, String newValue) {
        dbConnection.updateFlight(flightID, attribute, newValue);
    }

    public void addFlight(String origin, String destination, double seatPrice, String aircraft, int crewID, int maxSeat, String flightDate, String flightTime) {
        dbConnection.addFlight(origin, destination, seatPrice, aircraft, crewID, maxSeat, flightDate, flightTime);
    }

    public void removeFlight(int flightID) {
        dbConnection.removeFlight(flightID);
    }

    public void updateFlightCrew(int flightID, String newCrew) {
        dbConnection.updateFlightCrew(flightID, newCrew);
    }

}
