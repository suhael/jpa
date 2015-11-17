package com.bookcdstore.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.bookcdstore.entities.AgentSiteLocationMapping;
import com.bookcdstore.entities.Artist;
import com.bookcdstore.entities.CD;
import com.bookcdstore.entities.RemotePushConnection;
import com.bookcdstore.entities.RemotePushConnectionPK;
import com.bookcdstore.entities.Track;
import com.example.Concurrency;

public class Main {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void getConnection(){

		emf = Persistence.createEntityManagerFactory("my-pu");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Artist art1 = em.find(Artist.class, 1L);		

		CD cd = new CD();
		cd.setTitle("testcd3");
		cd.setDescription("testcd3");
		em.persist(cd);

		Track t = new Track();
		t.setTitle("test3");
		t.setDescription("test3");
		t.setCd(cd);
		t.setArtist(art1);

		em.persist(t);
		
		cd.setCreatedByArtists(new ArrayList<Artist>());
//		cd.setTracks(new ArrayList<Track>());		

//		Track t1 = em.find(Track.class, 5L);
		
		cd.getCreatedByArtists().add(art1);
//		cd.getTracks().add(t1);
		
		em.merge(cd);
		
/*		CD cd = em.find(CD.class, 425984L);
		System.out.println(cd.getTitle());
		
		List<Track> ts = cd.getTracks();
		System.out.println(ts.get(0).getDescription());
		
		em.remove(cd);*/
		
		em.getTransaction().commit();
		System.out.println("finished commit");

		em.close();
		emf.close();	
	}
	
	public void example2(){
		
		emf = Persistence.createEntityManagerFactory("my-pu");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		
/*		Landlord l = new Landlord();
		
		Room r = new Room();
		Set<Room> rooms = new HashSet<Room>();
		rooms.add(r);
		
		Property p = new Property();
		p.setLandlord(l);
		p.setRooms(rooms);
		
		em.persist(p);*/
/*		List<Integer> test = em.createNativeQuery("SELECT address.id FROM address JOIN artist ON address.id=artist.id AND artist.id=:two")
		.setParameter("two", 1)
		.getResultList();
		
		System.out.println(test.size());
		System.out.println(test.get(0));*/
		
		AgentSiteLocationMapping art1 = em.find(AgentSiteLocationMapping.class, 10051L);
		
		System.out.println("blha: " + art1.getAgentSiteId());
		
		

		em.getTransaction().commit();
		System.out.println("finished commit");

		em.close();
		emf.close();
	}
	
	public void example3(){
		emf = Persistence.createEntityManagerFactory("my-pu");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Concurrency concurrency = (Concurrency) em.createNativeQuery("SELECT * FROM testconcurrency WHERE testconcurrency.desc = :desc", Concurrency.class)
				.setParameter("desc", "test")
				//.getSingleResult();
		.getResultList().get(0);
		
		em.getTransaction().commit();
		System.out.println("finished commit");

		em.close();
		emf.close();
		
	}
	
	public void example4(){
		emf = Persistence.createEntityManagerFactory("my-pu");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Concurrency concurrency = (Concurrency) em.createNativeQuery("SELECT * FROM testconcurrency WHERE testconcurrency.desc = :desc", Concurrency.class)
				.setParameter("desc", "test")
				//.getSingleResult();
		.getResultList().get(0);
		
		em.getTransaction().commit();
		System.out.println("finished commit");

		em.close();
		emf.close();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		
		MyThreadOne thread1 = new MyThreadOne(em);
		MyThreadTwo thread2 = new MyThreadTwo(em);
		
		thread1.start();
		thread2.start();

	}

}
