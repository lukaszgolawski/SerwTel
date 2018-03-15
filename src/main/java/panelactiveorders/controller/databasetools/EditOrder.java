package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;

public class EditOrder extends ConnectDatabase {
    @Override
    protected void process() {
        entityManager.getTransaction().begin();
        Orders orders = entityManager.find(Orders.class, 2);
        orders.setStatus("");
        entityManager.merge(orders);
        entityManager.getTransaction().commit();
    }
}
