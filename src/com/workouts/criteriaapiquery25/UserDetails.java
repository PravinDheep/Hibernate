package com.workouts.criteriaapiquery25;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Details")
public class UserDetails {
	/*
	 * We have seen two ways of pulling up objects from the database, first by configuring entity objects and
	 * then doing session.get of the entity objects which returns the object and also the associations. The 
	 * second way is by using HQL writing queries and pulling up objects depending upon our requirements.
	 * The third way is using Criteria. NamedQueries are like sql, you have from, where clauses, join etc, as
	 * the query grows, it becomes bigger and bigger and its hard to maintain as it has parameters, 
	 * placeholders etc. Essentially its a query language, and have to know SQL and parmeters grow, query
	 * grows and hard to maintain, this is a problem, and we can now pull up data in hibernate, this is by 
	 * using a criteria API.
	 */
	@Id
	@Column(name="USERID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;

	@Column(name="USER_NAME")
	private String userName;

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}