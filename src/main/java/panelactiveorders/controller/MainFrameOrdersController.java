package panelactiveorders.controller;

import panelactiveorders.addorder.controller.AddOrderFrameController;
import panelactiveorders.controller.databasetools.AddOrder;
import panelactiveorders.view.MainFrameOrders;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameOrdersController {
    private MainFrameOrders mainFrameOrders;
    private JScrollPane jScrollPanel;
    private JTable tableDisplayDataOrders;
    private JButton addOrder;
    private JButton editOrder;
    private JButton closeOrder;
    private JButton generateInvoice;
    private JPanel mainPanel;

    public MainFrameOrdersController() {
        initComponents();
    }
    public void showMainFrameWindow() {
        mainFrameOrders.setVisible(true);
    }
    private void initComponents() {
        mainFrameOrders = new MainFrameOrders();
        mainFrameOrders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jScrollPanel = mainFrameOrders.getjScrollPanel();
        tableDisplayDataOrders = mainFrameOrders.getTableDisplayDataOrders();
        addOrder = mainFrameOrders.getAddOrder();
        editOrder = mainFrameOrders.getEditOrder();
        closeOrder = mainFrameOrders.getCloseOrder();
        generateInvoice = mainFrameOrders.getGenerateInvoice();
        mainPanel = mainFrameOrders.getMainPanel();
        addOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddOrderFrameController addOrderFrameController = new AddOrderFrameController();
                addOrderFrameController.showMainFrameWindow();
            }
        });
    }
}
