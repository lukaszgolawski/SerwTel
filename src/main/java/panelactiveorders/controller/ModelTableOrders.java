package panelactiveorders.controller;

import panelactiveorders.controller.databasetools.DisplayOrders;

import javax.swing.table.AbstractTableModel;

public class ModelTableOrders extends AbstractTableModel {
    private String[] columnNames;
    private DisplayOrders displayOrders;

    public void useDatabaseConnection() {
        displayOrders = new DisplayOrders();
        displayOrders.execute();

    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public int getRowCount() {
        return displayOrders.resultList.size();
    }

    @Override
    public String getColumnName(int col) {
        columnNames = new String[]{"Lp", "Model telefonu", "Status naprawy", "Opis problemu", "Data przyjęcia", "ID Klienta", "Klient", "Numer telefonu"};
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object[] list = displayOrders.resultList.get(row);
        switch (col) {
            case 0:
                return list[0]; //O.ID_ORDER
            case 1:
                return list[1];//O.MODEL_PHONE
            case 2:
                return list[2];//O.STATUS
            case 3:
                return list[3];//O.PROBLEM
            case 4:
                return list[4];//O.START_DATE
            case 5:
                return list[5];//C.ID
            case 6:
                return list[6];//C.NAME
            case 7:
                return list[7];//C.TELNUM
        }
        return null;

    }

}

