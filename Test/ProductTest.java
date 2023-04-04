import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p1, p2;

    @BeforeEach
    void setUp() {
        p1 = new Product("MacBook Air 2020", 1099);
        p2 = new Product("Samsung Galaxy S23 Ultra", 1299);
    }

    @Test
    void getProductName() {
        assertEquals("Samsung Galaxy S23 Ultra", p2.getProductName());
    }

    @Test
    void setProductName() {
        p1.setProductName("Iphone 13 Pro Max");
        assertEquals("Iphone 13 Pro Max", p1.getProductName());
    }

    @Test
    void getProductPrice() {
        assertEquals(1299, p2.getProductPrice());
    }

}