package panelactiveorders.controller;

import panelactiveorders.view.MainFrameOrders;

import javax.swing.*;

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
        jScrollPanel = mainFrameOrders.getjScrollPanel();
        tableDisplayDataOrders = mainFrameOrders.getTableDisplayDataOrders();
        addOrder = mainFrameOrders.getAddOrder();
        editOrder = mainFrameOrders.getEditOrder();
        closeOrder = mainFrameOrders.getCloseOrder();
        generateInvoice = mainFrameOrders.getGenerateInvoice();
        mainPanel = mainFrameOrders.getMainPanel();
    }
}
