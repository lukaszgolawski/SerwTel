package databasetool;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class ConnectDatabase {
    private EntityManagerFactory entityManagerFactory;
    public EntityManager entityManager;

    public void execute() {
        connector();
        process();
        closeConnection();
    }

    private void connector() {
        entityManagerFactory = Persistence.createEntityManagerFactory("manager");
        entityManager = entityManagerFactory.createEntityManager();
    }

    abstract protected void process();

    private void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
