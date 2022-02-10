package com.workouts.basichibernate1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		user1.setUserId(1);
		user1.setUserName("Pravin");
		//user1.setJoinedDate(LocalDateTime.now());
		user1.setJoinedDate(new Date());
		user1.setAddress("Pravin's address Coimbatore");
		user1.setDescription("Pravin's Description.Pravin's Description.Pravin's Description.Pravin's Description.");
		
		/* SessionFactory - one object per application, it creates sessions depending 
		on how many sessions you want throughout its execution period. If you want to 
		save something, you get a session from the session factory and use a session
		to be saved. All the methods and other pieces of code use the session factory
		to get hold of the session objects. */
		
		/*
		 * 1. Using the configuration file, we create the Session factory, that's the first step.
		 * 2. Create a session from the Session factory
		 * 3. Use the session to save model objects
		 */
		
		/* In order to build a session factory, what we need to do is to get the 
		 * configuration hibernate.cfg.xml. We need to tell hibernate to open up
		 * the configuration file. */
		
		/* // Before 5.3
		 * Configuration cfg = new Configuration(); cfg.configure("hibernate.cfg.xml");
		 * ServiceRegistry sreg = new
		 * StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		 * SessionFactory sf = cfg.buildSessionFactory(sreg);
		 */
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/basichibernate1/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session1 = sf.openSession();
		/* Before saving a session, need to create a transaction. Can save as many objects as we want, use this transaction to define
		   a single unit of work, can group all the objects to be saved inside this transaction.  */
		Transaction tr = session1.beginTransaction();
		session1.save(user1);
		tr.commit();
		session1.close();
		
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		UserDetails uget = session2.get(UserDetails.class, user1.getUserId());
		System.out.println("User ID is: " + uget.getUserName());
		session2.getTransaction().commit();
		session2.close();
		
	}
} 