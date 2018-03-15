package ConfirmationGenerator;

import databasetool.ConnectDatabase;
import panelactiveorders.controller.MainFrameOrdersController;

import javax.persistence.Query;
import java.util.List;

public class GeneratorHelper extends ConnectDatabase {
    public static List<Object[]> resultList;
    private MainFrameOrdersController mainFrameOrdersController = new MainFrameOrdersController();

    @Override
    protected void process() {
        Query query = entityManager.createNativeQuery("SELECT O.ID_ORDER, TO_CHAR(O.START_DATE, 'DD.MM.YYYY'), O.MODEL_PHONE, O.PROBLEM, C.NAME, C.NIP,C.STREET,C.PCODE, C.CITY, C.TELNUM "
                + "FROM ORDERS O JOIN CUSTOMERS C ON C.ID = O.ID_CUSTOMER WHERE O.ID_ORDER = " + mainFrameOrdersController.transferIdOrder + " AND C.ID = " + mainFrameOrdersController.transferIdCustomer);
        resultList = query.getResultList();
    }
}
