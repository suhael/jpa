package com.bookcdstore.main;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import com.example.Concurrency;

public class MyThreadOne extends Thread{
	
	private EntityManager em;
	
	public MyThreadOne(EntityManager em){
		this.em = em;
	}
	
	public void run(){

		em.getTransaction().begin();
		
		Concurrency concurrency = (Concurrency) em.createNativeQuery("SELECT * FROM testconcurrency WHERE testconcurrency.desc = :desc LOCK IN SHARE MODE", Concurrency.class)
				.setParameter("desc", "test")
				//.getSingleResult();
		.getResultList().get(0);
		
		//em.lock(concurrency, LockModeType.READ);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.getTransaction().commit();
		System.out.println("finished thread one");

		
	}
	

}
