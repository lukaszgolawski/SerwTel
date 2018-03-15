package panelactiveorders.controller;

import ConfirmationGenerator.GetConfirmation;
import com.itextpdf.text.DocumentException;
import panelactiveorders.addorder.controller.AddOrderFrameController;
import panelactiveorders.controller.databasetools.CloseOrder;
import panelactiveorders.controller.databasetools.DisplayOrders;
import panelactiveorders.controller.databasetools.EditOrder;
import panelactiveorders.view.MainFrameOrders;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private int indexSelectedRow;
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
        mainFrameOrders.setTitle("SerwTel");

        jScrollPanel = mainFrameOrders.getjScrollPanel();
        tableDisplayDataOrders = mainFrameOrders.getTableDisplayDataOrders();
        addOrder = mainFrameOrders.getAddOrder();
        editOrder = mainFrameOrders.getEditOrder();
        closeOrder = mainFrameOrders.getCloseOrder();
        buttonGenerateConfirmation = mainFrameOrders.getButtonGenerateConfirmation();
        mainPanel = mainFrameOrders.getMainPanel();

        tableDisplayDataOrders.setModel(new ModelTableOrders());

        widthColumn();
        createEvents();
    }
    private void createEvents(){
        tableDisplayDataOrders.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                indexSelectedRow = tableDisplayDataOrders.getSelectedRow();
            }
        });

        model.useDatabaseConnection();
        addOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddOrderFrameController addOrderFrameController = new AddOrderFrameController();
                addOrderFrameController.showMainFrameWindow();
                mainFrameOrders.dispose();
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
                EditOrder editOrder = new EditOrder();
                editOrder.execute();
            }
        });
        closeOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CloseOrder closeOrder = new CloseOrder();
                closeOrder.execute();
                model.useDatabaseConnection();
                tableDisplayDataOrders.getModel();
                tableDisplayDataOrders.repaint();
            }
        });
    }

    private void widthColumn(){
        tableDisplayDataOrders.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableDisplayDataOrders.getColumnModel().getColumn(1).setPreferredWidth(80);
        tableDisplayDataOrders.getColumnModel().getColumn(2).setPreferredWidth(200);
        tableDisplayDataOrders.getColumnModel().getColumn(3).setPreferredWidth(250);
        tableDisplayDataOrders.getColumnModel().getColumn(4).setPreferredWidth(120);
        tableDisplayDataOrders.getColumnModel().getColumn(5).setPreferredWidth(30);
        tableDisplayDataOrders.getColumnModel().getColumn(6).setPreferredWidth(150);
        tableDisplayDataOrders.getColumnModel().getColumn(7).setPreferredWidth(100);
    }
}
