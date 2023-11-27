
public class User{

    private String fullName;
    private String email;
    private Address address;
    private int adminID;
    private String password;

    public User(String fn, String em, Address ad){  
        this.fullName = fn;
        this.email = em;
        this.address = ad;

    }

    public User(int id, String pass){  
        this.adminID = id;
        this.password = pass;

    }

    public String regUser(){
        return this.fullName + ", " + this.email + ", " + this.address.toString();
    }

    public String getUser() {
        return "Name: "+ this.fullName + ", Email: " + this.email + ", Address: " + this.address.toString();
    }

    public string setName(String name){
        this.fullName = name;
    }

    public string setEmail(String em){
        this.email = em;
    }

    public string setAddress(Address ad){
        this.address = ad;
    }

}
