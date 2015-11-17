package com.bookcdstore.main;

import javax.persistence.EntityManager;

import com.example.Concurrency;

public class MyThreadTwo extends Thread{
	
	private EntityManager em;
	
	public MyThreadTwo(EntityManager em){
		this.em = em;
	}
	
	public void run(){

		em.getTransaction().begin();
		
		Concurrency concurrency = (Concurrency) em.createNativeQuery("SELECT * FROM testconcurrency WHERE testconcurrency.desc = :desc", Concurrency.class)
				.setParameter("desc", "test")
				//.getSingleResult();
		.getResultList().get(0);
		
		em.getTransaction().commit();
		System.out.println("finished thread two");

		
	}
	

}
