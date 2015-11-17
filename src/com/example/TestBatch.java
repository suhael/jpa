package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBatch {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	public Set<TestPK> rowsToUpdate = new HashSet<TestPK>();
	
	public void getConnection(){

		emf = Persistence.createEntityManagerFactory("my-pu");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Iterator<TestPK> rowsToUpdateIterator = rowsToUpdate.iterator();
		List newBatch = new ArrayList();
		int batchSize = 5;
		
		int i=1;
		while(rowsToUpdateIterator.hasNext()){
			newBatch.add(rowsToUpdateIterator.next());
			if((i%batchSize==0) || ((i==rowsToUpdate.size() && newBatch.size()>0 && i%batchSize!=0))){
				int updateCount =  em.createQuery("UPDATE Test e SET e.name = :name WHERE e.pk in (:pk)")
						.setParameter("name", "s")
						.setParameter("pk", newBatch)
						.executeUpdate();
		
				System.out.println(updateCount);
				newBatch.clear();
			}
			i++;
		}
		
//		List temp = new ArrayList(rowsToUpdate);
//		
//		
//		for(int i=1;i <= temp.size();i++){
//			
//			newBatch.add(temp.get(i-1));
//
//			if((i%batchSize==0) || ((i==temp.size() && newBatch.size()>0 && i%batchSize!=0))){
//				int updateCount =  em.createQuery("UPDATE Test e SET e.name = :name WHERE e.pk in (:pk)")
//						.setParameter("name", "s")
//						.setParameter("pk", newBatch)
//						.executeUpdate();
//				System.out.println(updateCount);
//				newBatch.clear();
//			}
/*			
			if(i==temp.size() && newBatch.size()>0 && i%batchSize!=0){
				int updateCount =  em.createQuery("UPDATE Test e SET e.name = :name WHERE e.pk in (:pk)")
						.setParameter("name", "s")
						.setParameter("pk", newBatch)
						.executeUpdate();
				System.out.println(updateCount);
			}*/
			
//		}
		
				
		
		em.getTransaction().commit();

		em.close();
		emf.close();	
	}

	public static void main(String[] args) {
		
		TestBatch t = new TestBatch();
		
		t.rowsToUpdate.add(new TestPK(1));
		t.rowsToUpdate.add(new TestPK(2));
		t.rowsToUpdate.add(new TestPK(3));
		t.rowsToUpdate.add(new TestPK(4));
		t.rowsToUpdate.add(new TestPK(5));
		t.rowsToUpdate.add(new TestPK(6));
		t.rowsToUpdate.add(new TestPK(7));
		t.rowsToUpdate.add(new TestPK(8));
		t.rowsToUpdate.add(new TestPK(9));
		//t.rowsToUpdate.add(new TestPK(10));
		
		t.getConnection();
	}

}
