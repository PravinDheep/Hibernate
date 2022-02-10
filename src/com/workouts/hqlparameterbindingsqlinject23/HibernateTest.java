 package com.workouts.hqlparameterbindingsqlinject23;



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
	 * 
	 */
	public static void main(String[] args) {
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/hqlparameterbindingsqlinject23/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		String minUserId = "48";
		String userName = "User 10";
		/*HQL*/
		Query query1 = session.createQuery("from UserDetails where userId > :userId and userName =:userName");
		query1.setParameter("userId", Integer.parseInt(minUserId));
		query1.setParameter("userName", userName);
		
		List<UserDetails> usersList1 = (List<UserDetails>) query1.list();
		
		tr.commit();
 		session.close();
 		
		for (UserDetails u : usersList1) {
			System.out.println(u.getUserName());
		}
 	}
}