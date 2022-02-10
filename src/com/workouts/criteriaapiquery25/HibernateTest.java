 package com.workouts.criteriaapiquery25;



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
	 * Criteria queries offer a type-safe alternative to HQL, JPQL and native SQL queries.
	 *
	 *	Restriction - to add any restriction(condition) to the criteria using the operations like eq, gr, le etc.
	 *  Projection - to use any aggregate function like Projections.max("userId"), 
	 *  Projections.count("userId"), Projections.property("userId"). 
	 *  Order - addOrder(Order.desc("userId").
	 *  QueryByExample - if we have too many properties and too many criteria values to satify, 
	 *  have specific values for half of the properties, creating criteria is going to be pain,
	 *  say .add, .add and need to create all these restrictions, a handy way to do this is by
	 *  using this query by example 
	 *  UserDetails exampleUser = new UserDetails();
	 *  exampleUser.setUserId(5);
	 *  exampleUser.setUserName("User 5");
	 *  
	 *  Example example = Example.create(exampleUser).(we can user excludeProperty("username"), enableLike etc.)
	 *  Criteria criteria = session.createCriteria(UserDetails.class).add(example);
	 *  Example doesn't consider two things, a null and primary key(doesn't consider 
	 *  exampleUser.setUserId(5)).
	 */
	public static void main(String[] args) {
		
		/* From 5.3 */
		ServiceRegistry sreg = new StandardServiceRegistryBuilder().configure("com/workouts/criteriaapiquery25/hibernate.cfg.xml").build();
		SessionFactory sf = new MetadataSources(sreg).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		/*
		Criteria criteria = session.createCriteria(UserDetails.class); //deprecated
		criteria.add(Restrictions.eq("userName", "User 10")); // Can add any Restrictions
		*/
		
		/* From hibernate 5.2, this uses JPA */
		
		// Create an instance of CriteriaBuilder by calling the getCriteriaBuilder() method
		// Create an instance of CriteriaQuery by calling the CriteriaBuilder createQuery() method
		// Create an instance of Query by calling the Session createQuery() method
		// Call the getResultList() method of the query object, which gives us the results

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteriaQuery = cb.createQuery(UserDetails.class);
		Root<UserDetails> root = criteriaQuery.from(UserDetails.class); // select fully
		criteriaQuery.select(root).where(cb.equal(root.get("userName"), "User 10")); // adding restrictions
		// All operations like equal, greater than reside in CriteriaBuilder(cb) 
		// Fetch, Join resides in Root<Entity> root.
		Query<UserDetails> query1  = session.createQuery(criteriaQuery);
		List<UserDetails> usersList1 = query1.getResultList();
		tr.commit();
 		session.close();
 		
		for (UserDetails u : usersList1) {
			System.out.println(u.getUserName());
		}
 	}
}