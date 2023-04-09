import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1;

    @BeforeEach
    void setUp()
    {
        p1 = new Product("AirPods", 199.99);
    }

    @Test
    void getProductName() {
        assertEquals("AirPods", p1.getProductName());
    }

    @Test
    void setProductName() {
        p1.setProductName("MacBook Pro");
        assertEquals("MacBook Pro", p1.getProductName());
    }

    @Test
    void getProductPrice() {
assertEquals(199.99, p1.getProductPrice());
    }

    @Test
    void setProductPrice() {
        p1.setProductPrice(24.99);
        assertEquals(24.99, p1.getProductPrice());
    }
}