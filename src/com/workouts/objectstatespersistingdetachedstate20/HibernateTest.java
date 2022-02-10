 package com.workouts.objectstatespersistingdetachedstate20;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {
	/* 
	 * When we read a data from the database, it might take 2 secs or 2mins, its not a better idea
	 * to update the values after getting the data and changing the values under one transaction.
	 * So, after reading data, we will close the transaction and session, this goes from persistent
	 * to detached state.
	 * After that, we will create a new transaction and sessiona and change the values of the data
	 * which is read, and update the data, this goes from detached to persistent session.
	 *
	 * Hibernate doesn't know if the object has changed after closing the session(try removing line 40(userDetails.setUserName("Updated username after session close");) and run the update), the query still
	 * tries to update the the object, because hibernate doesn't know if object has any changes. Since the object is coming from another
	 * session, hibernate doesn't not know what is the value that saved in the database, unless it does an update, its not sure, the current
	 * value of the user gets reflected to the record in the table. We can control this by using hibernate Entity annotation by giving as
	 * @org.hibernate.annotations.Entity(selectBeforeUpdate=true), but this is now depricated.
	 * 
	 */
	
	public static void main(String[] args) {
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/objectstatespersistingdetachedstate20/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 12);

		tr.commit();
 		session.close();
 		
 		userDetails.setUserName("Updated username after session close");
 		
 		//Again this code will be from a different method or a different class
 		session = sf.openSession();
 		session.beginTransaction();
 		session.update(userDetails);
 		userDetails.setUserName("Change after update");
 		session.getTransaction().commit();
 		session.close();
 	}
} 