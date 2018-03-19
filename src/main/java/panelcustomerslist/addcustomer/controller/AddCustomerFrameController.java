package panelcustomerslist.addcustomer.controller;

import panelcustomerslist.addcustomer.view.AddCustomerFrame;
import panelcustomerslist.controller.MainFrameCustomersController;
import panelcustomerslist.controller.databasetools.AddCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerFrameController {

    public static String addNameCustomer;
    public static String addNipCustomer;
    public static String addStreetCustomer;
    public static String addPostCodeCustomer;
    public static String addCityCustomer;
    public static String addNumTelCustomer;
    private AddCustomerFrame addCustomerFrame;
    private JTextField fieldNameCustomer;
    private JTextField fieldNipCustomer;
    private JTextField fieldStreetCustomer;
    private JTextField fieldPostCodeCustomer;
    private JTextField fieldCityCustomer;
    private JTextField fieldNumTelCustomer;
    private JButton buttonAddCustomer;
    private JButton buttonClear;
    private JButton buttonFindKrs;
    private JPanel mainPanelAddCustomer;

    MainFrameCustomersController mainFrameCustomersController = new MainFrameCustomersController();

    public AddCustomerFrameController() {
        initComponents();
    }

    public void showMainFrameWindow() {
        addCustomerFrame.setVisible(true);
    }

    private void initComponents() {
        addCustomerFrame = new AddCustomerFrame();
        addCustomerFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addCustomerFrame.setTitle("SerwTel");

        fieldNameCustomer = addCustomerFrame.getFieldNameCustomer();
        fieldNipCustomer = addCustomerFrame.getFieldNipCustomer();
        fieldStreetCustomer = addCustomerFrame.getFieldStreetCustomer();
        fieldPostCodeCustomer = addCustomerFrame.getFieldPostCodeCustomer();
        fieldCityCustomer = addCustomerFrame.getFieldCityCustomer();
        fieldNumTelCustomer = addCustomerFrame.getFieldNumTelCustomer();
        buttonAddCustomer = addCustomerFrame.getButtonAddCustomer();
        buttonClear = addCustomerFrame.getButtonClear();
        buttonFindKrs = addCustomerFrame.getButtonFindKrs();
        mainPanelAddCustomer = addCustomerFrame.getMainPanelAddCustomer();

        createEvents();
    }

    private void createEvents() {

        buttonAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fieldNameCustomer.getText().equals("") || fieldNumTelCustomer.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Musisz wpisać nazwe klienta i numer telefonu!");
                } else {
                    AddCustomer addCustomer = new AddCustomer();
                    addNameCustomer = fieldNameCustomer.getText();
                    addNipCustomer = fieldNipCustomer.getText();
                    addStreetCustomer = fieldStreetCustomer.getText();
                    addPostCodeCustomer = fieldPostCodeCustomer.getText();
                    addCityCustomer = fieldCityCustomer.getText();
                    addNumTelCustomer = fieldNumTelCustomer.getText();
                    addCustomer.execute();
                    mainFrameCustomersController.refreashTable();
                    mainFrameCustomersController.showMainFrameWindow();
                    addCustomerFrame.dispose();
                }
            }
        });
        buttonFindKrs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fieldNipCustomer.getText().equals("") || fieldNipCustomer.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Musisz wpisać numer NIP, który składa się z 10 znaków!");
                } else {
                    addNipCustomer = fieldNipCustomer.getText();
                    FindsDataCampany findsDataCampany = new FindsDataCampany();
                    fieldNameCustomer.setText(findsDataCampany.nameFound);
                    fieldStreetCustomer.setText(findsDataCampany.streetFound);
                    fieldPostCodeCustomer.setText(findsDataCampany.postCodeFound);
                    fieldCityCustomer.setText(findsDataCampany.cityFound);
                }
            }
        });
        addCustomerFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                addCustomerFrame.dispose();
                mainFrameCustomersController.showMainFrameWindow();
            }
        });
    }
}