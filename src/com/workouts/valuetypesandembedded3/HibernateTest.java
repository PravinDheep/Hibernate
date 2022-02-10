 package com.workouts.valuetypesandembedded3;

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
		//user1.setUserId(1); - natural key
		user1.setUserName("Pravin");

		UserDetails user2 = new UserDetails();
		user2.setUserName("PravinDheep");

		Address addr = new Address();
		addr.setStreet("JaiShreeNagar");
		addr.setCity("Coimbatore");
		addr.setState("TamilNadu");
		addr.setPincode("641019");
		
		user1.setAddress(addr);
		user2.setAddress(addr);
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/valuetypesandembedded3/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session1 = sf.openSession();
		/* Before saving a session, need to create a transaction. Can save as many objects as we want, use this transaction to define
		   a single unit of work, can group all the objects to be saved inside this transaction.  */
		Transaction tr = session1.beginTransaction();
		session1.save(user1);
		session1.save(user2);
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