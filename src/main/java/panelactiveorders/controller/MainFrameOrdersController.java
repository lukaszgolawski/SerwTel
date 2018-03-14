package panelactiveorders.controller;

import ConfirmationGenerator.GetConfirmation;
import com.itextpdf.text.DocumentException;
import panelactiveorders.addorder.controller.AddOrderFrameController;
import panelactiveorders.controller.databasetools.DisplayOrders;
import panelactiveorders.view.MainFrameOrders;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrameOrdersController {
    private MainFrameOrders mainFrameOrders;
    private JScrollPane jScrollPanel;
    private JTable tableDisplayDataOrders;
    private JButton addOrder;
    private JButton editOrder;
    private JButton closeOrder;
    private JButton buttonGenerateConfirmation;
    private JPanel mainPanel;

    private ModelTableOrders model = new ModelTableOrders();

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
        buttonGenerateConfirmation = mainFrameOrders.getButtonGenerateConfirmation();
        mainPanel = mainFrameOrders.getMainPanel();
        tableDisplayDataOrders.setModel(new ModelTableOrders());
        model.useDatabaseConnection();
        addOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddOrderFrameController addOrderFrameController = new AddOrderFrameController();
                addOrderFrameController.showMainFrameWindow();
            }
        });
        buttonGenerateConfirmation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetConfirmation getConfirmation = new GetConfirmation();
                try {
                    getConfirmation.execute();
                } catch (DocumentException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        editOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DisplayOrders displayOrders = new DisplayOrders();
                displayOrders.execute();
            }
        });
    }
}
