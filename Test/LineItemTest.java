import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {
    LineItem item;
    Product p1 = new Product("AirPod", 199);

    @BeforeEach
    void setUp() {
        item = new LineItem(p1, 3);
    }

    @Test
    void getLineQuantity() {
        assertEquals(3, item.getLineQuantity());
    }

    @Test
    void setLineQuantity() {
        item.setLineQuantity(1);
        assertEquals(1, item.getLineQuantity());
    }

    @Test
    void getLineTotal() {
        assertEquals(0, item.getLineTotal());
    }

    @Test
    void setLineTotal() {
        item.setLineTotal(499);
        assertEquals(499, item.getLineTotal());
    }

    @Test
    void calLineTotal() {
        assertEquals(597, item.calLineTotal());
    }
}