import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    Address a1;
    Address a2;

    @BeforeEach
    void setUp()
    {
        a1 = new Address("Ohio", "Cincinnati", "2121 Street", 45231);
        a2 = new Address("Texas", "Austin", "3454 Avenue", 77549);
    }

    @Test
    void getState() {
        assertEquals("Ohio", a1.getState());
    }

    @Test
    void setState() {
        a2.setState("Nevada");
        assertEquals("Nevada", a2.getState());
    }

    @Test
    void getCity() {
        assertEquals("Austin", a2.getCity());

    }

    @Test
    void setCity() {
        a1.setCity("Los Angeles");
        assertEquals("Los Angeles", a1.getCity());
    }

    @Test
    void getStreet() {
        assertEquals("2121 Street", a1.getStreet());

    }

    @Test
    void setStreet() {
        a2.setStreet("4565 Greenville Ave.");
        assertEquals("4565 Greenville Ave.", a2.getStreet());
    }

    @Test
    void getZipCode() {
        assertEquals(77549, a2.getZipCode());
    }

    @Test
    void setZipCode() {
        a1.setZipCode(11111);
        assertEquals(11111, a1.getZipCode());
    }
}