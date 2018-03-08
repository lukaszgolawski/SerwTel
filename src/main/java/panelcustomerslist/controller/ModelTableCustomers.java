package panelcustomerslist.controller;

import panelcustomerslist.controller.databasetools.Customers;
import panelcustomerslist.controller.databasetools.DisplayCustomers;

import javax.swing.table.AbstractTableModel;


public class ModelTableCustomers extends AbstractTableModel {
    private String[] columnNames;
    DisplayCustomers displayCustomers;
    public void useDatabaseConnection() {
        displayCustomers = new DisplayCustomers();
        displayCustomers.execute();

    }
    @Override
    public int getColumnCount() {
        return 7;
    }
    @Override
    public int getRowCount() {
        return displayCustomers.resultList.size();
    }
    @Override
    public String getColumnName(int col) {
        columnNames = new String[]{"Lp", "Nazwa", "NIP", "Ulica", "Kod pocztowy", "Miasto", "Numer telefony"};
        return columnNames[col];
    }
    @Override
    public Object getValueAt(int row, int col) {
        Customers c = displayCustomers.resultList.get(row);
        switch (col) {
            case 0:
                return c.getId();
            case 1:
                return c.getName();
            case 2:
                return c.getNip();
            case 3:
                return c.getStreet();
            case 4:
                return c.getPcode();
            case 5:
                return c.getCity();
            case 6:
                return c.getTelnum();
        }
        return null;

    }

}

