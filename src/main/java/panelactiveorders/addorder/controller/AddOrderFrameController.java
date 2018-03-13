package panelactiveorders.addorder.controller;

import panelactiveorders.addorder.view.AddOrderFrame;
import panelactiveorders.controller.databasetools.AddOrder;
import panelcustomerslist.controller.MainFrameCustomersController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddOrderFrameController {
    public static String addModelPhone;
    public static String addProblem;
    public static int addIdCustomer;
    private AddOrderFrame addOrderFrame;
    private JPanel mainPanelAddOrder;
    private JTextField fieldIdCustomer;
    private JTextField fieldModelPhone;
    private JTextField fieldData;
    private JButton buttonAddOrder;
    private JTextArea fieldProblem;
    private JButton buttonFindCustomer;
    private MainFrameCustomersController mainFrameCustomersController = new MainFrameCustomersController();

    public AddOrderFrameController() {
        initComponents();
    }


    public void showMainFrameWindow() {
        addOrderFrame.setVisible(true);
    }

    private void initComponents() {
        addOrderFrame = new AddOrderFrame();
        addOrderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanelAddOrder = addOrderFrame.getMainPanelAddOrder();
        fieldIdCustomer = addOrderFrame.getFieldIdCustomer();
        fieldModelPhone = addOrderFrame.getFieldModelPhone();
        fieldData = addOrderFrame.getFieldData();
        buttonAddOrder = addOrderFrame.getButtonAddOrder();
        fieldProblem = addOrderFrame.getFieldProblem();
        buttonFindCustomer = addOrderFrame.getButtonFindCustomer();
        fieldData.setText(String.valueOf(new Date()));
        fieldIdCustomer.setText(mainFrameCustomersController.transferId);
        buttonFindCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrameCustomersController.showMainFrameWindow();
                addOrderFrame.dispose();
            }
        });
        buttonAddOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddOrder addOrder = new AddOrder();
                addIdCustomer = Integer.valueOf(fieldIdCustomer.getText());
                addModelPhone = fieldModelPhone.getText();
                addProblem = fieldProblem.getText();
                addOrder.execute();
                addOrderFrame.dispose();
                mainFrameCustomersController.transferId = null;
            }
        });
    }
}
