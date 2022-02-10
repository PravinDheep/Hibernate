 package com.workouts.hql21;



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
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/hql21/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		/*HQL*/
		Query<UserDetails> query = session.createQuery("from UserDetails");
		List<UserDetails> list = query.getResultList();
		
		Query<UserDetails> query1 = session.createQuery("from UserDetails where userId > 51" );
		List<UserDetails> list1 = query1.getResultList();
		
		tr.commit();
 		session.close();
 		
 		System.out.println("Size of the list : " + list.size());
 		System.out.println("Size of the list1 : " + list1.size());
 	}
} 