public class Customer extends Address{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String state, String city, String street, String zipCode, String name) {
        super(state, city, street, zipCode);
        this.name = name;
    }

    public String getFormatCust (String state, String city, String street, String zipCode, String name)
    {
        String res = name + "\n" + street + "\n" + city + ", " + state + " " + zipCode;

        return  res;
    }
}
