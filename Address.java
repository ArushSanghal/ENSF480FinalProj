
public class Address{

    private String addressLine1;
    private String addressLine2;
    private String postalCode;

    public Address(){  

    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String toString() {
        return this.addressLine1 + " " + this.addressLine2 + " " + this.postalCode;
    }

}
