 package com.workouts.hqlpagination22;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {
	/* 
	 * Hibernate also has provided a method in which we can write query directly to access the database. In SQL
	 * we will think of tables, in HQL(Hibernate query language) we will be thinking of classes and objects.
	 * 
	 */
	public static void main(String[] args) {
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/hqlpagination22/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		/*
		 * Query<UserDetails> query2 =
		 * session.createQuery("from UserDetails where userId > 51" ); List<UserDetails>
		 * usersList2 = (List<UserDetails>) query2.getResultList();
		 */
		
		/*HQL*/
		//Query<UserDetails> query1 = session.createQuery("from UserDetails"); //loads all properties
		Query query1 = session.createQuery("select userName from UserDetails"); // loads the property specified alone
		query1.setFirstResult(4); // which is the starting result from the result has to be displayed.
		query1.setMaxResults(5); //per page, how many results to be shown
		//select new map(userId, userName) from UserDetails"
		//select max(userID) from UserDetails
		//List<UserDetails> usersList1 = (List<UserDetails>) query1.getResultList();
		List<String> usersList1 = (List<String>) query1.list();
		
		tr.commit();
 		session.close();
 		System.out.println("Size of the list : " + usersList1.size());
 		//System.out.println("Size of the list1 : " + usersList2.size());
 		
		/*
		 * for(UserDetails u : usersList1) { System.out.println(u.getUserName()); }
		 */
		for (String u : usersList1) {
			System.out.println(u);
		}
 		
 	}
}