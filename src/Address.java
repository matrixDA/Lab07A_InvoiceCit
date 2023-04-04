public class Address {
<<<<<<< HEAD
    private String state, city, street, zipCode;

    public Address(String state, String city, String street, String zipCode) {
=======
    private String state, city, street;
    private int zipCode;

    public Address(String state, String city, String street, int zipCode) {
>>>>>>> da1c004 (Initial commit)
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

<<<<<<< HEAD
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
=======
    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

>>>>>>> da1c004 (Initial commit)
}
