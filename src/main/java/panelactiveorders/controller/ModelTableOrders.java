package panelactiveorders.controller;

import panelactiveorders.controller.databasetools.DisplayOrders;
import panelactiveorders.controller.databasetools.Orders;

import javax.swing.table.AbstractTableModel;

public class ModelTableOrders extends AbstractTableModel {
    private String[] columnNames;
    DisplayOrders displayOrders;

    public void useDatabaseConnection() {
        displayOrders = new DisplayOrders();
        displayOrders.execute();

    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return displayOrders.resultList.size();
    }

    @Override
    public String getColumnName(int col) {
        columnNames = new String[]{"Lp", "Model telefonu", "Opis problemu", "Status naprawy", "Data przyjęcia"};
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Orders o = displayOrders.resultList.get(row);
        switch (col) {
            case 0:
                return o.getIdOrder();
            case 1:
                return o.getModelPhone();
            case 2:
                return o.getProblem();
            case 3:
                return o.getStatus();
            case 4:
                return o.getStartDate();
        }
        return null;

    }

}

