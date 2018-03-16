package panelactiveorders.addorder.controller;

import panelactiveorders.addorder.view.AddOrderFrame;
import panelactiveorders.controller.MainFrameOrdersController;
import panelactiveorders.controller.databasetools.AddOrder;
import panelcustomerslist.controller.MainFrameCustomersController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
    private JTextField fieldNameCustomer;
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
        addOrderFrame.setTitle("SerwTel");

        mainPanelAddOrder = addOrderFrame.getMainPanelAddOrder();
        fieldIdCustomer = addOrderFrame.getFieldIdCustomer();
        fieldModelPhone = addOrderFrame.getFieldModelPhone();
        fieldData = addOrderFrame.getFieldData();
        buttonAddOrder = addOrderFrame.getButtonAddOrder();
        fieldProblem = addOrderFrame.getFieldProblem();
        fieldNameCustomer = addOrderFrame.getFieldNameCustomer();
        buttonFindCustomer = addOrderFrame.getButtonFindCustomer();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY HH:mm");
        Date date = new Date();
        fieldData.setText(format.format(date));
        fieldIdCustomer.setText(mainFrameCustomersController.transferId);
        fieldNameCustomer.setText(mainFrameCustomersController.transferName);
        createEvents();
    }

    private void createEvents() {
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
                MainFrameOrdersController mainFrameOrdersController = new MainFrameOrdersController();
                mainFrameOrdersController.showMainFrameWindow();
            }
        });
    }
}
