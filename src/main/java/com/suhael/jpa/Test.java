package com.suhael.jpa;

import com.suhael.jpa.entities.Address;

import javax.persistence.EntityManager;

/**
 * Created by MSI on 15/02/2016.
 */
public class Test {

    public static void main(String[] args) {
        Address address = new Address();
        address.setCity("Dhaka")
                .setProvince("kjhk")
                .setCountry("Bangladesh")
                .setPostcode("1000")
                .setStreet("Poribagh");

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
