package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;

import javax.persistence.Query;
import java.util.List;


public class DisplayOrders extends ConnectDatabase {

    public static List<Object[]> resultList;

    @Override
    protected void process() {
        Query query = entityManager.createNativeQuery("SELECT O.ID_ORDER, O.MODEL_PHONE, O.STATUS, O.PROBLEM, O.START_DATE, C.ID, C.NAME, C.TELNUM FROM ORDERS O JOIN CUSTOMERS C ON C.ID = O.ID_CUSTOMER WHERE O.ACTIVE = 'T' ORDER BY O.ID_ORDER");
        resultList = query.getResultList();
    }
}
