package databasetool;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class ConnectDatabase {
    protected EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

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
