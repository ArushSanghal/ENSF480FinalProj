
public class User{

    private String fullName;
    private String email;
    private Address address;

    public User(){  

    }

    public String getUser() {
        return "Name: "+ this.fullName + ", Email: " + this.email + ", Address: " + this.address.toString();
    }

}
