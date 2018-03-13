package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;
import panelcustomerslist.controller.databasetools.Customers;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class DisplayOrders extends ConnectDatabase{

    public static List<Orders> resultList;
    @Override
    protected void process() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);

        Root<Orders> ordersRoot = criteriaQuery.from(Orders.class);
        Join<Orders,Customers> displayOrder = ordersRoot.join("fullOrder");
        criteriaQuery.select(displayOrder);
        //TypedQuery<> query = entityManager.createQuery(criteriaQuery);

        //resultList = query.getResultList();
    }
}
