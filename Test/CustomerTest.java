import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer c1;
    Customer c2;
    Address a1 = new Address("Ohio", "Cincinnati", "1234 Street", 12345);

    @BeforeEach
    void setUp()
    {
        c1 = new Customer("Amazon Inc.", a1);
    }

    @Test
    void getName() {
        assertEquals("Amazon Inc.", c1.getName());
    }

    @Test
    void setName() {
        c1.setName("Apple");
        assertEquals("Apple", c1.getName());
    }
}