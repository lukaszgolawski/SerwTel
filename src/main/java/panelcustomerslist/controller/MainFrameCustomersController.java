package panelcustomerslist.controller;


import panelactiveorders.addorder.controller.AddOrderFrameController;
import panelcustomerslist.addcustomer.controller.AddCustomerFrameController;
import panelcustomerslist.addcustomer.controller.EditCustomerFrameController;
import panelcustomerslist.controller.databasetools.DeleteCustomer;
import panelcustomerslist.view.MainFrameCustomers;

import javax.persistence.RollbackException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrameCustomersController {
    public static int idSelectedRow;
    public static String transferId;
    public static String transferName;
    public static String transferNip;
    public static String transferStreet;
    public static String transferPostCode;
    public static String transferCity;
    public static String transferNumTel;
    private MainFrameCustomers mainFrameCustomers;
    private JPanel mainPanel;
    private JTable tableDisplayDataCustomers;
    private JScrollPane jScrollPanel;
    private JButton addCustomer;
    private JButton editCustomer;
    private JButton deleteCustomer;
    private JButton buttonSelect;
    private int indexSelectedRow = -1;

    private ModelTableCustomers model = new ModelTableCustomers();

    public MainFrameCustomersController() {
        initComponents();
    }

    public void showMainFrameWindow() {
        mainFrameCustomers.setVisible(true);
    }

    public void refreashTable() {
        model.useDatabaseConnection();
        tableDisplayDataCustomers.getModel();
        tableDisplayDataCustomers.repaint();
    }

    private void initComponents() {
        mainFrameCustomers = new MainFrameCustomers();
        mainPanel = mainFrameCustomers.getMainPanel();
        mainFrameCustomers.setTitle("SerwTel");
        tableDisplayDataCustomers = mainFrameCustomers.getTableDisplayDataCustomers();
        jScrollPanel = mainFrameCustomers.getjScrollPanel();
        addCustomer = mainFrameCustomers.getButtonAddCustomer();
        editCustomer = mainFrameCustomers.getButtonEditCustomer();
        deleteCustomer = mainFrameCustomers.getButtonDeleteCustomer();
        buttonSelect = mainFrameCustomers.getButtonSelect();
        tableDisplayDataCustomers.setModel(new ModelTableCustomers());
        mainFrameCustomers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model.useDatabaseConnection();
        createEvents();

    }

    private void createEvents() {
        addCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCustomerEvent();
            }
        });
        editCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editCustomerEvent();
            }
        });
        deleteCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCustomerEvent();
            }
        });
        buttonSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectCustomerEvent();
            }
        });
        tableDisplayDataCustomers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                indexSelectedRow = tableDisplayDataCustomers.getSelectedRow();
            }
        });
        tableDisplayDataCustomers.addKeyListener(new KeyAdapter() {
        });
        tableDisplayDataCustomers.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 116) {
                    refreashTable();
                }
            }
        });
    }

    private void selectCustomerEvent() {
        transferId = String.valueOf(model.getValueAt(indexSelectedRow, 0));
        transferName = String.valueOf(model.getValueAt(indexSelectedRow, 1));
        AddOrderFrameController addOrderFrameController = new AddOrderFrameController();
        addOrderFrameController.showMainFrameWindow();
        mainFrameCustomers.dispose();
    }

    private void addCustomerEvent() {
        mainFrameCustomers.dispose();
        AddCustomerFrameController addCustomerFrameController = new AddCustomerFrameController();
        addCustomerFrameController.showMainFrameWindow();
    }

    private void editCustomerEvent() {
        try {
            transferId = String.valueOf(model.getValueAt(indexSelectedRow, 0));
            if (String.valueOf(model.getValueAt(indexSelectedRow, 2)).equals("null")) {
                transferNip = null;
            } else {
                transferNip = String.valueOf(model.getValueAt(indexSelectedRow, 2));
            }
            transferName = String.valueOf(model.getValueAt(indexSelectedRow, 1));
            transferStreet = String.valueOf(model.getValueAt(indexSelectedRow, 3));
            transferPostCode = String.valueOf(model.getValueAt(indexSelectedRow, 4));
            transferCity = String.valueOf(model.getValueAt(indexSelectedRow, 5));
            transferNumTel = String.valueOf(model.getValueAt(indexSelectedRow, 6));
            EditCustomerFrameController editCustomerFrameController = new EditCustomerFrameController();
            editCustomerFrameController.showMainFrameWindow();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Zaznacz pozycje do edycji");
        }
    }

    private void deleteCustomerEvent() {
        try {
            int choose = JOptionPane.showConfirmDialog(
                    null,
                    "Usunąć klienta " + String.valueOf(model.getValueAt(indexSelectedRow, 1)) + "?",
                    "Potwierdzenie operacji",
                    JOptionPane.YES_NO_OPTION);
            if (choose == 0) {
                idSelectedRow = convertVariableOnInt(model.getValueAt(indexSelectedRow, 0));
                DeleteCustomer deleteCustomer = new DeleteCustomer();
                deleteCustomer.execute();

                refreashTable();
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Zaznacz pozycje do usuniecia");
        } catch (RollbackException e) {
            JOptionPane.showMessageDialog(null, "Klient posiada podpięte zlecenia serwisowe. Usunięcie niemożliwe!");
        }
    }

    private int convertVariableOnInt(Object variableToConvert) {
        return Integer.valueOf(String.valueOf(variableToConvert));
    }

}
