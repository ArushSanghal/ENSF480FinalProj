import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class Crew{

    private String role;

    public Crew(String role){
        this.role = role;  
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void viewFlightPlan() {
    }


    public void browsePassengers() {
    }
}
