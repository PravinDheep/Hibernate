package com.workouts.hqlnamedquery24;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="UserDetails.byId", query="from UserDetails where userId = :userId")
//@NamedNativeQuery(name="UserDetails.name", query="select * from User_Details where User_Name = :userName", resultClass=UserDetails.class)
@Table(name="User_Details")
public class UserDetails {
	/*
	 * In the Named Query query parameter we can write HQL queries only, if we want to use
	 * SQL(native) query, we can go for Named Native Query (@NamedNativeQuery). In namednativequery we 
	 * should specify the resultClass=UserDetails.class, in order to cast into this specified object.But
	 * resultClass is optional, but using it can make the identifying the object easier.
	 */
	@Id
	@Column(name="USERID")
	@GeneratedValue
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