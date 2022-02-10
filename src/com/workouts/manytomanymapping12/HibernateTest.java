 package com.workouts.manytomanymapping12;

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

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("BENZCar");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("BMWCar");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		vehicle.getUserdetails().add(user);
		vehicle2.getUserdetails().add(user);
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/manytomanymapping12/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session1 = sf.openSession();
		Transaction tr = session1.beginTransaction();
  		session1.save(user);
  		session1.save(vehicle);
  		session1.save(vehicle2);
		tr.commit();
 		session1.close();
 		
 	}
} 