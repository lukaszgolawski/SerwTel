package panelcustomerslist.addcustomer.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerFrame extends JFrame{
    private static final int WIDTH = 320;
    private static final int HEIGHT = 250;
    private JTextField fieldNameCustomer;
    private JTextField fieldNipCustomer;
    private JTextField fieldStreetCustomer;
    private JTextField fieldPostCodeCustomer;
    private JTextField fieldCityCustomer;
    private JTextField fieldNumTelCustomer;
    private JButton buttonAddCustomer;
    private JButton buttonClear;
    private JButton buttonFindKrs;
    private JPanel mainPanelAddCustomer;

    public AddCustomerFrame(){
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanelAddCustomer);
        setLocationRelativeTo(null);
        clearTextButton();
    }

    public JTextField getFieldNameCustomer() {
        return fieldNameCustomer;
    }

    public JTextField getFieldNipCustomer() {
        return fieldNipCustomer;
    }

    public JTextField getFieldStreetCustomer() {
        return fieldStreetCustomer;
    }

    public JTextField getFieldPostCodeCustomer() {
        return fieldPostCodeCustomer;
    }

    public JTextField getFieldCityCustomer() {
        return fieldCityCustomer;
    }

    public JTextField getFieldNumTelCustomer() {
        return fieldNumTelCustomer;
    }

    public JButton getButtonAddCustomer() {
        return buttonAddCustomer;
    }

    public JButton getButtonClear() {
        return buttonClear;
    }

    public JButton getButtonFindKrs() {
        return buttonFindKrs;
    }

    public JPanel getMainPanelAddCustomer() {
        return mainPanelAddCustomer;
    }
    private void clearTextButton() {
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fieldNameCustomer.setText(null);
                fieldNipCustomer.setText(null);
                fieldStreetCustomer.setText(null);
                fieldCityCustomer.setText(null);
                fieldPostCodeCustomer.setText(null);
                fieldNumTelCustomer.setText(null);
            }
        });
    }
}
