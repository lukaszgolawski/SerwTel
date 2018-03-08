package panelcustomerslist.controller.databasetools;

import databasetool.ConnectDatabase;
import panelcustomerslist.addcustomer.controller.EditCustomerFrameController;

public class UpdateCustomer extends ConnectDatabase {
    EditCustomerFrameController editCustomerFrameController = new EditCustomerFrameController();
    protected void process() {
        entityManager.getTransaction().begin();
        Customers customers = new Customers();
        customers.setId(editCustomerFrameController.updateIdCustomer);
        customers.setName(editCustomerFrameController.updateNameCustomer);
        customers.setStreet(editCustomerFrameController.updateStreetCustomer);
        customers.setCity(editCustomerFrameController.updateCityCustomer);
        customers.setPcode(editCustomerFrameController.updatePostCodeCustomer);
        customers.setTelnum(editCustomerFrameController.updateNumTelCustomer);
        entityManager.merge(customers);
        entityManager.getTransaction().commit();
    }
}
