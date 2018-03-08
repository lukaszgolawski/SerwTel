package panelcustomerslist.controller.databasetools;

import databasetool.ConnectDatabase;
import org.junit.jupiter.api.Test;
import panelcustomerslist.addcustomer.controller.AddCustomerFrameController;

public class AddCustomer extends ConnectDatabase{
    AddCustomerFrameController addCustomerFrameController = new AddCustomerFrameController();
    @Test
    protected void process() {
        Customers customers = new Customers();
        customers.setName(addCustomerFrameController.addNameCustomer);
        customers.setNip(addCustomerFrameController.addNipCustomer);
        customers.setStreet(addCustomerFrameController.addStreetCustomer);
        customers.setCity(addCustomerFrameController.addCityCustomer);
        customers.setPcode(addCustomerFrameController.addPostCodeCustomer);
        customers.setTelnum(addCustomerFrameController.addNumTelCustomer);

        entityManager.getTransaction().begin();
        entityManager.persist(customers);
        entityManager.getTransaction().commit();
    }
}
