package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;
import panelactiveorders.controller.MainFrameOrdersController;

public class EditOrder extends ConnectDatabase {
    MainFrameOrdersController mainFrameOrdersController = new MainFrameOrdersController();
    @Override
    protected void process() {
        entityManager.getTransaction().begin();
        Orders orders = entityManager.find(Orders.class, mainFrameOrdersController.transferIdOrder);
        orders.setStatus(mainFrameOrdersController.transferStatus);
        entityManager.merge(orders);
        entityManager.getTransaction().commit();
    }
}
