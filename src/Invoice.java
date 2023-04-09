import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Invoice{
    private Customer customer;
    private LineItem lineItem;
    private double amountDue;

    private ArrayList <LineItem> itemList = new ArrayList<>();

    public Invoice(Customer customer) {
        this.customer = customer;
    }

    public void calcProduct(Product product, int prodQuantity)
    {
        LineItem totalItem = new LineItem(product, prodQuantity);
        itemList.add(totalItem);
    }

    public String formatDisplay()
    {
        String res = String.format("%80s", "INVOICE\n")
                + customer.getFormatCust() +
                "\n=========================================================\n";

        res += "Item\t\t\tQty\tPrice\tTotal\n";

                for (LineItem item : itemList)
                {
                    res += item.formattedLineItem() + "\n";
                }

                res += "=========================================================\n" +
                        String.format("Amount Due:\t\t\t\t\t$%.2f", getAmountDue()) + "\n";

        return res;
    }

    public double getAmountDue() {
        double amountDue = 0;
        for (LineItem item : itemList) {
            amountDue += item.calLineTotal();
        }
        return amountDue;
    }


}


