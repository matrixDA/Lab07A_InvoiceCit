import java.util.Objects;

public class Customer extends Address{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name, String street, String city, String state, int zipCode) {
        super(state, city, street, zipCode);
        this.name = name;
    }

    public String getFormatCust(String name, String street, String city, String state, int zipCode)
    {
        String res = name + "\n" +
                    street + "\n" +
                    city + ", " + state + " " + zipCode;

        return  res;
    }
}
