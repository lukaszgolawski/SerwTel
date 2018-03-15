package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;
import panelactiveorders.controller.MainFrameOrdersController;

import java.util.Date;

public class CloseOrder extends ConnectDatabase{
    MainFrameOrdersController mainFrameOrdersController = new MainFrameOrdersController();

    @Override
    protected void process() {
        entityManager.getTransaction().begin();
        Orders orders = entityManager.find(Orders.class, mainFrameOrdersController.transferIdOrder);
        orders.setFinishDate(new Date());
        orders.setActive('F');
        orders.setStatus("Odebrano");
        entityManager.merge(orders);
        entityManager.getTransaction().commit();
    }
}
