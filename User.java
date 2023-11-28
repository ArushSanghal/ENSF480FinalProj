import java.sql.ResultSet;
import java.util.List;

public class User{

    private String fullName;
    private String email;
    private Address address;
    private String userPassword;
    private String adminUsername;
    private int adminID;
    private String adminPassword;
    private DatabaseConnection db;

    public User(String fn, String em, Address ad, String pass){  
        this.fullName = fn;
        this.email = em;
        this.address = ad;
        this.userPassword = pass;

    }

    public User(String admName, String pass, int adminID){  
        this.adminUsername = admName;
        this.adminPassword = pass;

    }

    public User(String em, String pass){
        this.email = em;
        this.userPassword = pass;
    }

    public void regUser(){
        db = new DatabaseConnection();
        db.insertUser(fullName, email, address, userPassword);
    }

    public boolean loginUser(String inputEmail, String inputPass){
        db = new DatabaseConnection();

        List<String> emailList = db.extractUserEmails();
        List<String> passwordList = db.extractUserPasskeys();

        if (emailList.contains(inputEmail) && passwordList.contains(inputPass)){
            System.out.println("User found");
            return true;
        }
        System.out.println("User not found");
        return false;
    }

    public boolean loginAdmin(String inputUsername, String inputPass){

        db = new DatabaseConnection();

        List<String> usernameList = db.extractAdminUsernames();
        List<String> passwordList = db.extractAdminPasswords();
        
        if (usernameList.contains(inputUsername) && passwordList.contains(inputPass)){
            System.out.println("User found");
            return true;
        }
        System.out.println("User not found");
        return false;
    }

}
