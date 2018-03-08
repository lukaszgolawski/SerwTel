package panelcustomerslist.view;


import javax.swing.*;

public class MainFrameCustomers extends JFrame {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;
    private JPanel mainPanel;
    private JTable tableDisplayDataCustomers;
    private JScrollPane jScrollPanel;
    private JButton addCustomer;
    private JButton editCustomer;
    private JButton deleteCustomer;

    public MainFrameCustomers() {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
    }

    public JTable getTableDisplayDataCustomers() {
        return tableDisplayDataCustomers;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JScrollPane getjScrollPanel() {
        return jScrollPanel;
    }

    public JButton getAddCustomer() {
        return addCustomer;
    }

    public JButton getEditCustomer() {
        return editCustomer;
    }

    public JButton getDeleteCustomer() {
        return deleteCustomer;
    }
}

