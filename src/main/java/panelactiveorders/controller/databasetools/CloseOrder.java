package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;

import java.util.Date;

public class CloseOrder extends ConnectDatabase{
    @Override
    protected void process() {
        entityManager.getTransaction().begin();
        Orders orders = entityManager.find(Orders.class, 2);
        orders.setFinishDate(new Date());
        orders.setActive('F');
        orders.setStatus("Odebrano");
        entityManager.merge(orders);
        entityManager.getTransaction().commit();
    }
}
