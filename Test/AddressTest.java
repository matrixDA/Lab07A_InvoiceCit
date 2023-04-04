import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    Address a1;
    Address a2;
    @BeforeEach
    void setUp() {
         a1 = new Address("OH", "Cincinnati", "1111 Alpine Ave.", 45231);
         a2 = new Address("TX", "Dallas", "1202 Car Drive", 75195);
    }

    @Test
    void getState() {
        assertEquals("OH", a1.getState());
    }

    @Test
    void setState() {
        a1.setState("CA");
        assertEquals("CA", a1.getState());
    }

    @Test
    void getCity() {
        assertEquals("Dallas", a2.getCity());
    }

    @Test
    void setCity() {
        a2.setCity("San Antonio");
        assertEquals("San Antonio", a2.getCity());
    }

    @Test
    void getStreet() {
        assertEquals("1111 Alpine Ave.", a1.getStreet());
    }

    @Test
    void setStreet() {
        a1.setStreet("3243 Davis Ave.");
        assertEquals("3243 Davis Ave.", a1.getStreet());
    }

    @Test
    void getZipCode() {
        assertEquals(75195, a2.getZipCode());
    }

    @Test
    void setZipCode() {
        a2.setZipCode(34521);
        assertEquals(34521, a2.getZipCode());
    }

}