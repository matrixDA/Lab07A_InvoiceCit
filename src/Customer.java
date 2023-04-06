import java.util.Objects;

public class Customer{

    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public Customer(String name, String street, String city, String state, int zipCode) {
        super(state, city, street, zipCode);
        this.name = name;
    }*/

    public Customer(String name, Address address){
        this.name = name;
        this.address = address;

    }

    public String getFormatCust()
    {
        String res = name + "\n" +
        address.getStreet() + "\n" +
        address.getCity() + ", " + address.getState() + " " + address.getZipCode();

        return  res;
    }
}
