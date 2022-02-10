 package com.workouts.proxyobjectseagerlazyfetch8;

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
		UserDetails user = new UserDetails();
		user.setUserName("Pravin");

		//UserDetails user = new UserDetails();
		user.setUserName("PravinDheep");

		Address addr = new Address();
		addr.setStreet("JaiShreeNagar");
		addr.setCity("Coimbatore");
		addr.setState("TamilNadu");
		addr.setPincode("641019");
		
		Address addr1 = new Address();
		addr1.setStreet("SamsonSchoolStreet");
		addr1.setCity("Nilgiris");
		addr1.setState("TamilNadu");
		addr1.setPincode("643001");

		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr1);
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/proxyobjectseagerlazyfetch8/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session1 = sf.openSession();
		Transaction tr = session1.beginTransaction();
		session1.save(user);
		//session1.save(user2);
		tr.commit();
 		session1.close();
 		
 		user = null;
 		
		session1 = sf.openSession();
		user = session1.get(UserDetails.class, 1);
		// session1.get will pull only the first level values, doesn't get getListOfAddresses().
		// Lazy initialization: You donot initialize the entire object, you only initialize the first level variables, 
		// and then you initialize the list only when you actually access it.
		/* System.out.println(user.getListOfAddresses().size()); */
		session1.close();
		System.out.println(user.getListOfAddresses().size());
		// Proxy object cannot be used outside of session, if you want to access, declare fetch type as Eager. @ElementCollection(fetch=FetchType.EAGER)
	}
} 