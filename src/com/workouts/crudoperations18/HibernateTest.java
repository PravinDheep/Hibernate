 package com.workouts.crudoperations18;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/crudoperations18/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		/*
		 * for(int i=0; i < 10; i++) { UserDetails user = new UserDetails();
		 * user.setUserName("PravinDheep" + i); session1.save(user); }  //Create
		 */
		UserDetails user = (UserDetails) session.get(UserDetails.class, 12); //Read
		System.out.println("User name pulled up is : " + user.getUserName());
		
		//session.delete(user); //delete
		user.setUserName("PravinDheep12 updated");
		session.update(user); //update
		
		tr.commit();
 		session.close();
 		
 	}
} 