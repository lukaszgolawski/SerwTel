package panelactiveorders.view;

import javax.swing.*;

public class MainFrameOrders extends JFrame{
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 500;
    private JScrollPane jScrollPanel;
    private JTable tableDisplayDataOrders;
    private JButton addOrder;
    private JButton editOrder;
    private JButton closeOrder;
    private JButton buttonGenerateConfirmation;
    private JPanel mainPanel;

    public MainFrameOrders() {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
    }

    public JScrollPane getjScrollPanel() {
        return jScrollPanel;
    }

    public JTable getTableDisplayDataOrders() {
        return tableDisplayDataOrders;
    }

    public JButton getAddOrder() {
        return addOrder;
    }

    public JButton getEditOrder() {
        return editOrder;
    }

    public JButton getCloseOrder() {
        return closeOrder;
    }

    public JButton getButtonGenerateConfirmation() {
        return buttonGenerateConfirmation;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
