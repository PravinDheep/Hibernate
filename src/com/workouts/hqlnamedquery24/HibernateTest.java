 package com.workouts.hqlnamedquery24;



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
	 * Its acutally best practice to consolidate all queries in one particular place. Named Queries allows
	 * you to write queries at the Entity level.
	 */
	public static void main(String[] args) {
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/hqlnamedquery24/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		String userId="51";
		/*HQL*/
		Query<UserDetails> query1 = session.getNamedQuery("UserDetails.byId");
		query1.setParameter("userId", Integer.parseInt(userId));
		
		//Query<UserDetails> query1 = session.getNamedQuery("UserDetails.name"); // Named Native Query
		//query1.setParameter("userName", "User 10");
		
		List<UserDetails> usersList1 = (List<UserDetails>) query1.getResultList();
		
		tr.commit();
 		session.close();
 		
		for (UserDetails u : usersList1) {
			System.out.println(u.getUserName());
		}
 	}
}