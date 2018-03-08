package panelcustomerslist.controller.databasetools;


import databasetool.ConnectDatabase;
import panelcustomerslist.controller.MainFrameCustomersController;

public class DeleteCustomer extends ConnectDatabase {
    MainFrameCustomersController mainFrameCustomersController = new MainFrameCustomersController();

    protected void process() {
        Customers customers = entityManager.find(Customers.class, mainFrameCustomersController.idSelectedRow);
        entityManager.getTransaction().begin();
        entityManager.remove(customers);
        entityManager.getTransaction().commit();
    }
}
