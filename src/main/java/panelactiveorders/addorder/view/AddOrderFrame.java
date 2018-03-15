package panelactiveorders.addorder.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrderFrame extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    private JPanel mainPanelAddOrder;
    private JTextField fieldIdCustomer;
    private JTextField fieldModelPhone;
    private JTextField fieldData;
    private JButton buttonAddOrder;
    private JButton buttonClear;
    private JTextArea fieldProblem;
    private JButton buttonFindCustomer;
    private JTextField fieldNameCustomer;

    public AddOrderFrame() {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanelAddOrder);
        setLocationRelativeTo(null);
        clearTextButton();
    }
    private void clearTextButton() {
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fieldProblem.setText(null);
                fieldModelPhone.setText(null);
            }
        });
    }

    public JPanel getMainPanelAddOrder() {
        return mainPanelAddOrder;
    }

    public JTextField getFieldIdCustomer() {
        return fieldIdCustomer;
    }

    public JTextField getFieldModelPhone() {
        return fieldModelPhone;
    }

    public JTextField getFieldData() {
        return fieldData;
    }

    public JButton getButtonAddOrder() {
        return buttonAddOrder;
    }

    public JTextArea getFieldProblem() {
        return fieldProblem;
    }

    public JButton getButtonFindCustomer() {
        return buttonFindCustomer;
    }

    public JTextField getFieldNameCustomer() {
        return fieldNameCustomer;
    }
}
