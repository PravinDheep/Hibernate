package com.workouts.hqlparameterbindingsqlinject23;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class UserDetails {
	/*
	 * 
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