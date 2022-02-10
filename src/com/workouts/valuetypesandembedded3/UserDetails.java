package com.workouts.valuetypesandembedded3;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
//Treat this class as Entity and needs to save it.
@Entity
@Table(name="USER_DETAILS_VALUEEMBEDDEDTYPES3")
public class UserDetails {
	
	/*
	 * Value object - Value object is an object that has data and even that has to be saved in the 
	 * database, but it doesn't have meaning as itself, it provides meaning to someother object. 
	 * 
	 * An Entity have meaning on its own, but the value object doesn't have meaning on its own. 
	 * 
	 * Eg: Address object without User class will not have any meaning, so purpose of address object is to 
	 * provide value to User object. You can have an Entity(Eg:Login) inside another entity(User) which has 
	 * a meaning on its own.
	 */
	
	@Id
	@Column(name="USER_ID_PRIMARYKEY")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId; //natural key
	@Column(name="USER_NAME")
	private String userName;
	
	/*
	 * You can also have another annotation here, this annotation says the object is an Embedded object.This is
	 * not mandatory, if the referring class is marked as @Embeddable. 
	 */
	@Embedded
	private Address address;

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

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