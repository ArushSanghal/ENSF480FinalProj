
public class User{

    private String fullName;
    private String email;
    private Address address;

    public User(String fn, String em, Address ad){  
        this.fullName = fn;
        this.email = em;
        this.address = ad;

    }

    public String regUser(){
        return this.fullName + ", " + this.email + ", " + this.address.toString();
    }

    public String getUser() {
        return "Name: "+ this.fullName + ", Email: " + this.email + ", Address: " + this.address.toString();
    }

}
