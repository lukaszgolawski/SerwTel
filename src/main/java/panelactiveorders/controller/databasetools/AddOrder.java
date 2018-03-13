package panelactiveorders.controller.databasetools;

import databasetool.ConnectDatabase;
import panelactiveorders.addorder.controller.AddOrderFrameController;
import panelcustomerslist.controller.databasetools.Customers;

import java.util.Date;

public class AddOrder extends ConnectDatabase {
    AddOrderFrameController addOrderFrameController = new AddOrderFrameController();
    @Override
    protected void process() {
        Customers customers = entityManager.find(Customers.class, addOrderFrameController.addIdCustomer);

        Orders orders = new Orders();
        orders.setModelPhone(addOrderFrameController.addModelPhone);
        orders.setProblem(addOrderFrameController.addProblem);
        orders.setStatus("Przyjęto");
        orders.setStartDate(new Date());
        orders.setFinishDate(null);
        orders.setCustomers(customers);

        entityManager.getTransaction().begin();
       // entityManager.persist(customers);
        entityManager.persist(orders);
        entityManager.getTransaction().commit();
    }
}
