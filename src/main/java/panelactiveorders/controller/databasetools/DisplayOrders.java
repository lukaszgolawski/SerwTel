package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DisplayOrders extends ConnectDatabase{

    public static List<Orders> resultList;
    @Override
    protected void process() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Orders> criteriaQuery = builder.createQuery(Orders.class);

        Root<Orders> customersRoot = criteriaQuery.from(Orders.class);
        TypedQuery<Orders> query = entityManager.createQuery(criteriaQuery);

        resultList = query.getResultList();
    }
}
