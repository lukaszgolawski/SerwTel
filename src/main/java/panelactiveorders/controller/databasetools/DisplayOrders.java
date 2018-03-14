package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;

import javax.persistence.Query;
import java.util.List;


public class DisplayOrders extends ConnectDatabase {

    public static List<Object[]> resultList;

    @Override
    protected void process() {
        Query query = entityManager.createNativeQuery("SELECT O.ID_ORDER, C.NAME, C.TELNUM, O.MODEL_PHONE, O.STATUS, O.PROBLEM, O.START_DATE FROM ORDERS O JOIN CUSTOMERS C ON C.ID = O.ID_CUSTOMER");
        resultList = query.getResultList();
    }
}
