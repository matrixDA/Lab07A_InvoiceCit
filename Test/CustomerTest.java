import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer c1, c2;

    @BeforeEach
    void setUp() {
        c1 = new Customer("Sam Adam", "3214 Frank Ave.", "Venis", "CA", 23455);
        c2 = new Customer("Ted Heart", "Domino Pky.", "New York", "NY", 12563);
    }

    @Test
    void getName() {
        assertEquals("Sam Adam", c1.getName());
    }

    @Test
    void setName() {
        c2.setName("Gary Toad");
        assertEquals("Gary Toad", c2.getName());
    }

    @Test
    void equals()
    {
        c1.setName("Ted Heart");
        c1.setState("Domino Pky.");
        c1.setCity("New York");
        c1.setState("NY");
        c1.setZipCode(12563);
        assertEquals(true, c1.equals(c2));
    }

}