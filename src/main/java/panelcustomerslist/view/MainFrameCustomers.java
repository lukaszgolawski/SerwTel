package panelcustomerslist.view;


import javax.swing.*;

public class MainFrameCustomers extends JFrame {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;
    private JPanel mainPanel;
    private JTable tableDisplayDataCustomers;
    private JScrollPane jScrollPanel;
    private JButton buttonAddCustomer;
    private JButton buttonEditCustomer;
    private JButton buttonDeleteCustomer;
    private JButton buttonSelect;

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

    public JButton getButtonAddCustomer() {
        return buttonAddCustomer;
    }

    public JButton getButtonEditCustomer() {
        return buttonEditCustomer;
    }

    public JButton getButtonDeleteCustomer() {
        return buttonDeleteCustomer;
    }

    public JButton getButtonSelect() {
        return buttonSelect;
    }
}

