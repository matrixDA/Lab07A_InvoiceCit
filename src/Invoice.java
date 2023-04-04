import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Invoice extends JFrame{
    JPanel mainPnl, customerPnl, productPnl, displayPnl, controlPnl;
    JTextField custNameTF, custStreetTF, custCityTF, custStateTF, custZipTF, prodNameTF, prodCostTF, prodQuanTF;
    JLabel custNameLbl, custStreetLbl, custCityLbl, custStateLbl, custZipLbl, prodNameLbl, prodCostLbl, prodQuanLbl;
    JButton custBtn, prodBtn, amtDueBtn,clearBtn, quitBtn;
    JTextArea textArea;
    JScrollPane pane;

    DecimalFormat df = new DecimalFormat("$##.00");

    ArrayList<LineItem> lineItems = new ArrayList<>();
    public Invoice()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeigh = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(675,750);
        setLocation(screenWidth / 4, (screenHeigh - 750) / 3);

        setTitle("Invoice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createGUI();
        setVisible(true);
    }

    public void createGUI() {
        mainPnl = new JPanel();
        customerPnl = new JPanel();
        productPnl = new JPanel();
        displayPnl = new JPanel();
        controlPnl = new JPanel();

        mainPnl.setLayout(new BoxLayout(mainPnl, BoxLayout.PAGE_AXIS));
        mainPnl.add(customerPnl);
        mainPnl.add(productPnl);
        mainPnl.add(controlPnl);
        mainPnl.add(displayPnl);


        add(mainPnl);
        createCustomerPnl();
        createProductPnl();
        createDisplayPnl();
        createControlPnl();

    }

    public void createCustomerPnl() {

        customerPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2,true),"Personal Info"));
        custNameLbl = new JLabel("Name: ");
        custNameTF = new JTextField(10);

        custStreetLbl = new JLabel("Street Address: ");
        custStreetTF = new JTextField(15);

        custCityLbl = new JLabel("City: ");
        custCityTF = new JTextField(10);

        custStateLbl = new JLabel("State: ");
        custStateTF = new JTextField(10);

        custZipLbl = new JLabel("Zip Code: ");
        custZipTF = new JTextField(10);


        customerPnl.add(custNameLbl);
        customerPnl.add(custNameTF);
        customerPnl.add(custStreetLbl);
        customerPnl.add(custStreetTF);
        customerPnl.add(custCityLbl);
        customerPnl.add(custCityTF);
        customerPnl.add(custStateLbl);
        customerPnl.add(custStateTF);
        customerPnl.add(custZipLbl);
        customerPnl.add(custZipTF);
    }

    public void createProductPnl() {

        productPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2,  true),"Item Info"));

        prodNameLbl = new JLabel("Item Name: ");
        prodNameTF = new JTextField(12);
        prodNameTF.setEnabled(false);

        prodCostLbl = new JLabel("Cost: ");
        prodCostTF = new JTextField(7);
        prodCostTF.setEnabled(false);

        prodQuanLbl = new JLabel("Amount: ");
        prodQuanTF = new JTextField(5);
        prodQuanTF.setEnabled(false);

        productPnl.add(prodNameLbl);
        productPnl.add(prodNameTF);
        productPnl.add(prodCostLbl);
        productPnl.add(prodCostTF);
        productPnl.add(prodQuanLbl);
        productPnl.add(prodQuanTF);

    }

    public void createDisplayPnl() {
        textArea = new JTextArea(15, 46);
        textArea.setBackground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 14));

        pane = new JScrollPane(textArea);

        displayPnl.add(pane);

    }

    public void createControlPnl() {
        controlPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2,  true),"Control Options"));

        custBtn = new JButton("Add Customer");
        custBtn.addActionListener((ActionEvent ae) -> {
            try {
                   if (custNameTF.getText().isEmpty() || custStreetTF.getText().isEmpty() || custCityTF.getText().isEmpty() || custStateTF.getText().isEmpty() || custZipTF.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "One or more Address field is empty. Please Make sure you input data");
                }
                if (Integer.parseInt(custZipTF.getText()) < 10000 || Integer.parseInt(custZipTF.getText()) > 99999)
                {
                    JOptionPane.showMessageDialog(null, "Zip Code has be a 5 digit number");
                }
                else
                {
                    disableCustomer();
                    displayCustomers(new Customer(custNameTF.getText(), custStreetTF.getText(), custCityTF.getText(), custStateTF.getText(), Integer.parseInt(custZipTF.getText())));
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Zip Code cannot be a string value. Please enter a 5 digit number");

            }

        });

        prodBtn = new JButton("Add Item");
        prodBtn.setEnabled(false);
        prodBtn.addActionListener((ActionEvent ae) -> {

            try {
                if (prodNameTF.getText().isEmpty() || prodCostTF.getText().isEmpty() || prodQuanTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "One or more Product field is empty. Please Make sure you input data");
                }
                else
                {
                    displayProduct(new Product(prodNameTF.getText(), Double.valueOf(prodCostTF.getText())), Integer.valueOf(prodQuanTF.getText()));
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cost and Amount cannot have a string value.\nMake sure Amount is a whole number.");
            }

        });

        amtDueBtn = new JButton("Total");
        amtDueBtn.setEnabled(false);
        amtDueBtn.addActionListener((ActionEvent ae) -> {
            disableTotal();
            calTotal();
        });

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener((ActionEvent ae) -> clearInvoice());

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(custBtn);
        controlPnl.add(prodBtn);
        controlPnl.add(amtDueBtn);
        controlPnl.add(clearBtn);
        controlPnl.add(quitBtn);
    }

    private void disableTotal() {
        prodBtn.setEnabled(false);
        amtDueBtn.setEnabled(false);

        prodNameTF.setEnabled(false);
        prodCostTF.setEnabled(false);
        prodQuanTF.setEnabled(false);
    }

    private void clearInvoice() {
        textArea.setText(" ");
        enableCustomer();
        prodBtn.setEnabled(false);
        amtDueBtn.setEnabled(false);

        custNameTF.setText("");
        custStreetTF.setText("");
        custCityTF.setText("");
        custStateTF.setText("");
        custZipTF.setText("");

        prodNameTF.setText("");
        prodCostTF.setText("");
        prodQuanTF.setText("");


    }

    private void calTotal() {
        double totalPrice = 0;
       for (LineItem total : lineItems)
       {
           totalPrice += total.calLineTotal(total.getProductPrice(), total.getLineQuantity());
       }
       textArea.append("\n======================================================\n");
       textArea.append("Amount Due:      " + df.format(totalPrice));

    }

    private void displayProduct(Product product, int prodQuantity) {

        amtDueBtn.setEnabled(true);
        LineItem newItem = new LineItem(product.getProductName(), product.getProductPrice(), prodQuantity);
        lineItems.add(newItem);

        prodNameTF.setText("");
        prodCostTF.setText("");
        prodQuanTF.setText("");

        textArea.append(newItem.getProductName() + "\t\t\t");
        textArea.append(" " + newItem.getLineQuantity() + "\t");
        textArea.append(df.format(newItem.getProductPrice())  + "\t");
        textArea.append(df.format(newItem.calLineTotal(newItem.getProductPrice(), newItem.getLineQuantity())) + "\n");


    }
    private void displayCustomers(Customer customer)
    {
        custBtn.setEnabled(false);
        prodBtn.setEnabled(true);

     //   textArea.append("\t\tINVOICE\n");
        textArea.append(String.format("%75s", "INVOICE\n"));
        textArea.append("\n" + customer.getFormatCust(customer.getName(), customer.getStreet(), customer.getCity(), customer.getState(), customer.getZipCode()));
        textArea.append("\n======================================================\n");
        textArea.append( "Item\t\t\tQty\tPrice\tTotal\n");

    }
    private void disableCustomer() {
        custNameTF.setEnabled(false);
        custStreetTF.setEnabled(false);
        custCityTF.setEnabled(false);
        custStateTF.setEnabled(false);
        custZipTF.setEnabled(false);

        custBtn.setEnabled(false);

        prodNameTF.setEnabled(true);
        prodQuanTF.setEnabled(true);
        prodCostTF.setEnabled(true);

    }
    private void enableCustomer()
    {
        custNameTF.setEnabled(true);
        custStreetTF.setEnabled(true);
        custCityTF.setEnabled(true);
        custStateTF.setEnabled(true);
        custZipTF.setEnabled(true);

        custBtn.setEnabled(true);

        prodNameTF.setEnabled(false);
        prodQuanTF.setEnabled(false);
        prodCostTF.setEnabled(false);
    }
}
