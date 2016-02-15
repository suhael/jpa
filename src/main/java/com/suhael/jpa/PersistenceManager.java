package com.suhael.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example");

    private static PersistenceManager ourInstance = new PersistenceManager();

    public static PersistenceManager getPersistenceManager() {
        return ourInstance;
    }

    private PersistenceManager() {
    }

    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
    public void close() {
        emFactory.close();
    }
}
