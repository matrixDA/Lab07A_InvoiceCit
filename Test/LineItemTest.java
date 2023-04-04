import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {

    LineItem lP1, lP2;

    @BeforeEach
    void setUp() {
        lP1 = new LineItem("Iphone", 1250, 1, 1250);
        lP2 = new LineItem("Apples", 3.24, 6, 19.44);
    }



    @Test
    void getQuantity() {
        assertEquals(6, lP2.getLineQuantity());
    }

    @Test
    void setQuantity() {
        lP2.setLineQuantity(12);
        assertEquals(12, lP2.getLineQuantity());
    }

    @Test
    void getLineTotal() {
        assertEquals(1250, lP1.getLineTotal());
    }

    @Test
    void setLineTotal() {
        lP1.setLineTotal(6.66);
        assertEquals(6.66, lP1.getLineTotal());
    }
}