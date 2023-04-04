public class LineItem extends Product{

    private int quantity;
    private double lineTotal;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return lineTotal;
    }

    public double calTotal(double price, int quantity) {

        double total;
        total = price * quantity;

        return total;
    }

    public void setTotal(double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public LineItem(String name, double price, int quantity, double lineTotal) {
        super(name, price);
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }
}
