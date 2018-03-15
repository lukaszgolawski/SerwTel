package panelcustomerslist.addcustomer.controller;

import panelcustomerslist.addcustomer.view.AddCustomerFrame;
import panelcustomerslist.controller.MainFrameCustomersController;
import panelcustomerslist.controller.databasetools.UpdateCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCustomerFrameController {
    public static int updateIdCustomer;
    public static String updateNameCustomer;
    public static String updateNipCustomer;
    public static String updateStreetCustomer;
    public static String updatePostCodeCustomer;
    public static String updateCityCustomer;
    public static String updateNumTelCustomer;
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

    public EditCustomerFrameController() {
        initComponents();
    }

    public void showMainFrameWindow() {
        addCustomerFrame.setVisible(true);
    }

    private void initComponents() {
        addCustomerFrame = new AddCustomerFrame();
        addCustomerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        buttonEvents();
        buttonAddCustomer.setText("Zapisz");
        fieldNameCustomer.setText(mainFrameCustomersController.transferName);
        fieldNipCustomer.setText(mainFrameCustomersController.transferNip);
        fieldStreetCustomer.setText(mainFrameCustomersController.transferStreet);
        fieldCityCustomer.setText(mainFrameCustomersController.transferCity);
        fieldPostCodeCustomer.setText(mainFrameCustomersController.transferPostCode);
        fieldNumTelCustomer.setText(mainFrameCustomersController.transferNumTel);
        updateIdCustomer = Integer.valueOf(mainFrameCustomersController.transferId);
    }

    private void buttonEvents() {
        buttonAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateCustomer updateCustomer = new UpdateCustomer();
                updateNameCustomer = fieldNameCustomer.getText();
                updateNipCustomer = fieldNipCustomer.getText();
                updateStreetCustomer = fieldStreetCustomer.getText();
                updatePostCodeCustomer = fieldPostCodeCustomer.getText();
                updateCityCustomer = fieldCityCustomer.getText();
                updateNumTelCustomer = fieldNumTelCustomer.getText();
                updateCustomer.execute();
                mainFrameCustomersController.refreashTable();
                 addCustomerFrame.dispose();
            }
        });
    }
}
