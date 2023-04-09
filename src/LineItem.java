import javax.swing.plaf.PanelUI;

public class LineItem{

    private int quantity;
    private double lineTotal;
    private Product product;

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
    public double calLineTotal() {
        double total = 0;

        total = product.getProductPrice() * getLineQuantity();

        return total;
    }

    public void setLineTotal(double lineTotal) {
        this.lineTotal = lineTotal;
    }
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String formattedLineItem()
    {

        String res = product.getProductName() + "\t\t\t" + getLineQuantity() + "\t" + String.format("$%.2f", product.getProductPrice())
                + "\t" +String.format("$%.2f", calLineTotal(product.getProductPrice(), getLineQuantity()));

        return res;

    }
}
