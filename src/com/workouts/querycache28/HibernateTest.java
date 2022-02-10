 package com.workouts.querycache28;



import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {
	/*
	 * First level cache - implemented by Session object.
	 * Second level cache 
	 * 		- Across sessions in an application
	 * 		- Across applications
	 * 		- Across clusters
	 */
	public static void main(String[] args) {
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/secondlevelcache27/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).addAnnotatedClass(UserDetails.class).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails user where user.userId = 44");
		query.setCacheable(true);
		List users = query.list();
		
		tr.commit();
 		session.close();
 		
 		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		Query query1 = session2.createQuery("from UserDetails user where user.userId = 44");
		query1.setCacheable(true); 
		/* If not having the values, pull up the database, set the query cache and
		 * the query cache is already having the values, pull up the values from 
		 * the query cache.
		 */
		List users1 = query1.list();
		
		session2.getTransaction().commit();
		session2.close();
		
		
 	}
}