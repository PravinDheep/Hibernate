package com.workouts.primarykey2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
//Treat this class as Entity and needs to save it.
@Entity
@Table(name="USER_DETAILSPRIMARY2")
public class UserDetails {	
	/* Natural Key - The columns which has business rule which dictates every user have to provide distinct email address(say in user 
	 * registration), on registering, in this case emailAddress can be primary key, such columns which actually are there for a business 
	 * reason but then you assign one of them a primary key, such keys are called Natural keys. (Eg: emailId column in user registration, 
	 * emailid will be primary and mandatory). Surrogate Key - These type of columns act as a primary key alone, it doesn't carry any 
	 * business significance, you have a separate column just to act as a key, such case is called as Surrogate key ( Eg: Serial no 
	 * column in a table).
	 * 
	 * If we have a natural key, we need to provide the value as it has the business significance, we need to be able to control it, 
	 * we but if we have a surrogate key, then we can ask hibernate to do that for us.
	 * 
	 */

	/*
	 * 	@GeneratedValue(strategy=GenerationType. AUTO, IDENTITY, SEQUENCE, TABLE
	 *  SEQUENCE - create a new table hibernate_sequence and will hold the nextVal, whenever a database record is created, the user_id gets 
	 *  created by getting the value from the hibernate_sequence nextVal value, called as sequence hilo in hibernate.
	 *  TABLE - will have separate Table(hibernate_sequences, contains sequence_name, next_val), which contains the last used primary key, so 
	 *  that it can be incremented and get the next value.
	 *  IDENTITY - few databases support identity, it increments the value. 
	 *  AUTO - automatically hibernate taken the best generation based on the database, it is the recommended one. 
	 *  
	 * */
	@Id
	@Column(name="USER_ID_PRIMARYKEY")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId; //natural key
	@Column(name="USER_NAME")
	private String userName;
	
	@Transient
	private String notes;
	
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