 package com.workouts.secondlevelcache27;



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
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 44);
		user.setUserName("User updated");
		
		/* UserDetails user1 = (UserDetails) session1.get(UserDetails.class, 44); 
		 Only one select even though this is enabled, because it detects from the cache. */
		
		tr.commit();
 		session.close();
 		
 		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		UserDetails user1 = (UserDetails) session2.get(UserDetails.class, 44); 
		// multiple time select statement displayed, because when the session is closed,
		// the cache is lost. When second level cache is displayed, only one select statement
		// should be displayed.
		
		session2.getTransaction().commit();
		session2.close();
		
		
 	}
}