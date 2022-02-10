 package com.workouts.objectstates19;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {
	/*
	 * After a save is performed (session.save), if you add any statements, hibernate will perform
	 * update statements only. Hibernate figures out the least number of updates that need to be
	 * made.
	 * 
	 * Before saving a object, it is said to be in transient state, and once we hand over the object
	 * to the hibernate by session.save(user), it is said to be in a persistent state. When its in 
	 * persistent state, hibernate tracks the changes, thats why it is updating the statements
	 * after saving. Once if we make session.close, it is said to be in a detached state.
	 * 
	 * When a session.get is performed, the state is persistent state. 
	 * The persistent state object will go into a Transient state when we do a session.delete.
	 */
	
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("Test user");
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/objectstates19/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.save(user);
		
		user.setUserName("Updated user");
		user.setUserName("Updated user again");
		
		tr.commit();
 		session.close();
 		
 	}
} 