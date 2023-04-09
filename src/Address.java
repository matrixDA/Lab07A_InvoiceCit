
public class Address{

public class Address {

    private String state, city, street;
    private int zipCode;

    public Address(String state, String city, String street, int zipCode) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public int getZipCode() {
        return zipCode;
    }


    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
