package panelcustomerslist.controller.databasetools;


import databasetool.ConnectDatabase;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DisplayCustomers extends ConnectDatabase {
    public static List<Customers> resultList;
    protected void process() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customers> criteriaQuery = builder.createQuery(Customers.class);

        Root<Customers> customersRoot = criteriaQuery.from(Customers.class);
        TypedQuery<Customers> query = entityManager.createQuery(criteriaQuery);

        resultList = query.getResultList();
    }
}
