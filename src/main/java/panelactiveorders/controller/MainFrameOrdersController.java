package panelactiveorders.controller;

import ConfirmationGenerator.GetConfirmation;
import com.itextpdf.text.DocumentException;
import panelactiveorders.addorder.controller.AddOrderFrameController;
import panelactiveorders.controller.databasetools.CloseOrder;
import panelactiveorders.controller.databasetools.EditOrder;
import panelactiveorders.view.MainFrameOrders;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrameOrdersController {
    public static String transferStatus;
    public static int transferIdOrder;
    public static int transferIdCustomer;
    private MainFrameOrders mainFrameOrders;
    private JScrollPane jScrollPanel;
    private JTable tableDisplayDataOrders;
    private JButton addOrder;
    private JButton editOrder;
    private JButton closeOrder;
    private JButton buttonGenerateConfirmation;
    private JPanel mainPanel;
    private JTextArea fieldStatus;
    private JLabel labelStatus;
    private JButton buttonSaveStatus;
    private JButton buttonCancel;
    private int indexSelectedRow = -1;
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
        fieldStatus = mainFrameOrders.getTextArea1();
        labelStatus = mainFrameOrders.getLabelStatus();
        buttonSaveStatus = mainFrameOrders.getButtonSaveStatus();
        buttonCancel = mainFrameOrders.getButtonCancel();

        fieldStatus.setVisible(false);
        labelStatus.setVisible(false);
        buttonSaveStatus.setVisible(false);
        buttonCancel.setVisible(false);

        tableDisplayDataOrders.setModel(new ModelTableOrders());

        widthColumn();
        createEvents();
    }

    private void createEvents() {
        tableDisplayDataOrders.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                indexSelectedRow = tableDisplayDataOrders.getSelectedRow();
            }
        });

        model.useDatabaseConnection();
        addOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addOrderEvent();
            }
        });
        buttonGenerateConfirmation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatConfirmationEvent();
            }
        });
        editOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editOrderEvent();
            }
        });
        closeOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeOrderEvent();
            }
        });
        buttonSaveStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveStatusEvent();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelEvent();
            }
        });
    }

    private void widthColumn() {
        tableDisplayDataOrders.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableDisplayDataOrders.getColumnModel().getColumn(1).setPreferredWidth(80);
        tableDisplayDataOrders.getColumnModel().getColumn(2).setPreferredWidth(200);
        tableDisplayDataOrders.getColumnModel().getColumn(3).setPreferredWidth(250);
        tableDisplayDataOrders.getColumnModel().getColumn(4).setPreferredWidth(120);
        tableDisplayDataOrders.getColumnModel().getColumn(5).setPreferredWidth(30);
        tableDisplayDataOrders.getColumnModel().getColumn(6).setPreferredWidth(150);
        tableDisplayDataOrders.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private int convertVariableOnInt(Object variableToConvert) {
        return Integer.valueOf(String.valueOf(variableToConvert));
    }

    private void addOrderEvent() {
        AddOrderFrameController addOrderFrameController = new AddOrderFrameController();
        addOrderFrameController.showMainFrameWindow();
        mainFrameOrders.dispose();
    }

    private void editOrderEvent() {
        try {
            fieldStatus.setText(String.valueOf(model.getValueAt(indexSelectedRow, 2)));
            transferIdOrder = convertVariableOnInt(model.getValueAt(indexSelectedRow, 0));
            fieldStatus.setVisible(true);
            labelStatus.setVisible(true);
            buttonSaveStatus.setVisible(true);
            buttonCancel.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Zaznacz pozycje");
        }
    }

    private void closeOrderEvent() {
        try {
            int choose = JOptionPane.showConfirmDialog(
                    null,
                    "Czy usunąć zlecenie serwisowe o numerze " + String.valueOf(model.getValueAt(indexSelectedRow, 0)) + " od klienta " + String.valueOf(model.getValueAt(indexSelectedRow, 6)) + "?",
                    "Potwierdzenie operacji",
                    JOptionPane.YES_NO_OPTION);
            if (choose == 0) {
                CloseOrder closeOrder = new CloseOrder();
                transferIdOrder = convertVariableOnInt(model.getValueAt(indexSelectedRow, 0));
                closeOrder.execute();
                model.useDatabaseConnection();
                tableDisplayDataOrders.getModel();
                tableDisplayDataOrders.repaint();
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Zaznacz pozycje");
        }
    }

    private void generatConfirmationEvent() {
        try {
            int choose = JOptionPane.showConfirmDialog(
                    null,
                    "Czy utworzyć potwierdzenie przyjęcia sprzętu do serwisu o nr zlecenia " + String.valueOf(model.getValueAt(indexSelectedRow, 0)) + " od klienta " + String.valueOf(model.getValueAt(indexSelectedRow, 6)) + "?",
                    "Potwierdzenie operacji",
                    JOptionPane.YES_NO_OPTION);
            if (choose == 0) {
                transferIdOrder = convertVariableOnInt(model.getValueAt(indexSelectedRow, 0));
                transferIdCustomer = convertVariableOnInt(model.getValueAt(indexSelectedRow, 5));
                GetConfirmation getConfirmation = new GetConfirmation();
                try {
                    getConfirmation.execute();
                } catch (DocumentException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Zaznacz pozycje");
        }
    }

    private void saveStatusEvent() {
        EditOrder editOrder = new EditOrder();
        transferStatus = fieldStatus.getText();
        editOrder.execute();
        model.useDatabaseConnection();
        tableDisplayDataOrders.getModel();
        tableDisplayDataOrders.repaint();
        fieldStatus.setVisible(false);
        labelStatus.setVisible(false);
        buttonSaveStatus.setVisible(false);
        buttonCancel.setVisible(false);
    }

    private void cancelEvent() {
        fieldStatus.setVisible(false);
        labelStatus.setVisible(false);
        buttonSaveStatus.setVisible(false);
        buttonCancel.setVisible(false);
    }
}
