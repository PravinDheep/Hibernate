 package com.workouts.cascadetypes13;

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
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/cascadetypes13/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session1 = sf.openSession();
		Transaction tr = session1.beginTransaction();
  		
		//session1.save(user); //Save only the parent object, in this case UserDetails, no need saving Vehicle.
		session1.save(user); //Save only the parent object, in this case UserDetails, no need saving Vehicle.
		
		
		tr.commit();
 		session1.close();
 		
 	}
} 