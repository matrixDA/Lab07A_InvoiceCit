import java.text.DecimalFormat;

public class LineItem extends Product{

    private int quantity;
    private double lineTotal;

    public int getLineQuantity() {
        return quantity;
    }

    public void setLineQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLineTotal() {
        return lineTotal;
    }

    public double calLineTotal(double productPrice, int quantity) {

        double total = 0;
        total = productPrice * quantity;

        return total;
    }

    public void setLineTotal(double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public LineItem(String productName, double productPrice, int quantity) {
        super(productName, productPrice);
        this.quantity = quantity;
    }
    public LineItem(String productName, double productPrice, int quantity, double lineTotal) {
        super(productName, productPrice);
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }
}
