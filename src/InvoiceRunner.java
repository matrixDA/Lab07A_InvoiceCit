import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class InvoiceRunner extends JFrame {

    public static void main(String[] args) {
        InvoiceRunner Invoice = new InvoiceRunner();
    }
    JPanel mainPnl, customerPnl, productPnl, displayPnl, controlPnl, controlPnl2, formatPnl;
    JTextField custNameTF, custStreetTF, custCityTF, custStateTF, custZipTF, prodNameTF, prodCostTF, prodQuanTF;
    JLabel custNameLbl, custStreetLbl, custCityLbl, custStateLbl, custZipLbl, prodNameLbl, prodCostLbl, prodQuanLbl;
    JButton custBtn, prodBtn, clearBtn, quitBtn;
    JTextArea textArea;
    JScrollPane pane;

    LineItem lineItem;
    Invoice invoice;
    Product product;
    Customer customer;
    Address address;

    ArrayList<LineItem> lines = new ArrayList<>();

    public InvoiceRunner() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeigh = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(765, 500);
        setLocation(screenWidth / 4, (screenHeigh - 320) / 3);

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
        formatPnl = new JPanel();
        controlPnl = new JPanel();
        controlPnl2 = new JPanel();

        mainPnl.add(customerPnl);
        mainPnl.add(productPnl);
        mainPnl.add(formatPnl);
        formatPnl.add(controlPnl);
        formatPnl.add(displayPnl);
        formatPnl.add(controlPnl2);

        add(mainPnl);
        createCustomerPnl();
        createProductPnl();
        createDisplayPnl();
        createControlPnl();
        createControlPnl2();
    }

    public void createCustomerPnl() {
        customerPnl.setLayout(new GridLayout(3, 2));
        customerPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "ADDRESS"));
        customerPnl.setAlignmentX(Component.CENTER_ALIGNMENT);

        custNameLbl = new JLabel("Name: ", JLabel.RIGHT);
        custNameTF = new JTextField(10);

        custStreetLbl = new JLabel("Street: ", JLabel.RIGHT);
        custStreetTF = new JTextField(10);

        custCityLbl = new JLabel("City: ", JLabel.RIGHT);
        custCityTF = new JTextField(5);

        custStateLbl = new JLabel("State: ", JLabel.RIGHT);
        custStateTF = new JTextField(5);

        custZipLbl = new JLabel("Zip Code: ", JLabel.RIGHT);
        custZipTF = new JTextField(7);


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

        productPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Item Info"));
        productPnl.setLayout(new GridLayout(1, 3));
        productPnl.setAlignmentX(Component.CENTER_ALIGNMENT);

        prodNameLbl = new JLabel("Item Name: ", JLabel.RIGHT);
        prodNameTF = new JTextField(7);
        prodNameTF.setEnabled(false);

        prodCostLbl = new JLabel("Cost: ", JLabel.RIGHT);
        prodCostTF = new JTextField(7);
        prodCostTF.setEnabled(false);

        prodQuanLbl = new JLabel("Amount: ", JLabel.RIGHT);
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

        textArea = new JTextArea(15, 50);
        textArea.setBackground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 14));

        pane = new JScrollPane(textArea);

        displayPnl.add(pane);

    }

    public void createControlPnl() {
        controlPnl.setLayout(new GridLayout(2, 1));
        custBtn = new JButton("Add Customer");
        custBtn.addActionListener((ActionEvent ae) -> {
            try {
                if (custNameTF.getText().isEmpty() || custStreetTF.getText().isEmpty() || custCityTF.getText().isEmpty() || custStateTF.getText().isEmpty() || custZipTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "One or more Address field is empty. Please Make sure you input data");
                }
                else if (Integer.parseInt(custZipTF.getText()) < 10000 || Integer.parseInt(custZipTF.getText()) > 99999) {
                    JOptionPane.showMessageDialog(null, "Zip Code has be a 5 digit number");
                }
                else {
                    tempClear();
                    disableCustBtn();
                    displayAddress(new Address(custStateTF.getText(), custCityTF.getText(), custStreetTF.getText(),
                            Integer.valueOf(custZipTF.getText())), custNameTF.getText());
                }
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Zip Code cannot be a string value. Please enter a 5 digit number");
            }
        });

        prodBtn = new JButton("Add Item");
        prodBtn.setEnabled(false);
        prodBtn.addActionListener((ActionEvent ae) -> {
            try {
                if (prodNameTF.getText().isEmpty() || prodCostTF.getText().isEmpty() || prodQuanTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "One or more Item Info fields is empty. Please make sure you input data");
                } else {
                    tempClear();
                    displayProduct(new Product(prodNameTF.getText(), Double.valueOf(prodCostTF.getText())), Integer.valueOf(prodQuanTF.getText()));
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cost and Amount cannot have a string value.\nMake sure it's a whole number.");
            }
        });
        controlPnl.add(custBtn);
        controlPnl.add(prodBtn);
    }

    private void tempClear() {
        textArea.setText(" ");
    }

    private void displayProduct(Product product, Integer prodQ) {
        LineItem newItem = new LineItem(product, prodQ);

        invoice.calcProduct(product, prodQ);

        textArea.append(invoice.formatDisplay());
    }

    private void displayAddress(Address address,String cName) {
        Customer c = new Customer(cName, address);
        invoice = new Invoice(c);
       textArea.append(invoice.formatDisplay());

    }

    public void createControlPnl2() {
        controlPnl2.setLayout(new GridLayout(2, 1));

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener((ActionEvent ae) -> clearInvoice());

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl2.add(clearBtn);
        controlPnl2.add(quitBtn);
    }
    private void clearInvoice() {
        textArea.setText(" ");
        custNameTF.setText("");
        custStreetTF.setText("");
        custCityTF.setText("");
        custStateTF.setText("");
        custZipTF.setText("");

        prodNameTF.setText("");
        prodCostTF.setText("");
        prodQuanTF.setText("");

        enableCustomer();
    }
    private void disableCustBtn() {
        custNameTF.setEnabled(false);
        custStreetTF.setEnabled(false);
        custCityTF.setEnabled(false);
        custStateTF.setEnabled(false);
        custZipTF.setEnabled(false);

        custBtn.setEnabled(false);

        prodNameTF.setEnabled(true);
        prodQuanTF.setEnabled(true);
        prodCostTF.setEnabled(true);
        prodBtn.setEnabled(true);
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
        prodBtn.setEnabled(false);
    }
}

