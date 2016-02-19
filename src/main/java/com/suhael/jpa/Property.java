package com.suhael.jpa;

import com.suhael.jpa.entities.property.Address;

import javax.persistence.EntityManager;

public class Property {

    public static void main(String[] args) {

        Address address = new Address();
        address.setLine1("67");
        address.setLine2("Rowan Ave");
        address.setTown("High Wycombe");

        EntityManager em = PersistenceManager.getPersistenceManager().getEntityManager();
        em.getTransaction()
                .begin();
        em.persist(address);
        em.getTransaction()
                .commit();


        em.close();
        PersistenceManager.getPersistenceManager().close();
    }
}
