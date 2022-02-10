package com.workouts.proxyobjectseagerlazyfetch8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="PROXYOBJECTSEAGERLAZYFETCH8")
public class UserDetails {
	/*
	 * Hibernate, instead of getting the actual object its looking for the proxy object, it gets you proxy the first time, its
	 * a dynamic sub-class of your actual object. The proxy class fills outs the first level values and hands you
	 * the proxy object class not the actual object class. When the listOfAddresses() method called, it first fetch
	 * the values from the database and populate the list of address. After it does that, then it calls the parent
	 * listOfAddresses, here getter will run fine, before you calls up, the proxy object pulls the value from the 
	 * database. So consumer doesn't need to worry about, if the object is proxy or the User.
	 * 
	 * 
	 * 
	 */
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS_COLLECTION7", 
			joinColumns=@JoinColumn(name="USER_ID_FOREIGNKEY"))
	private Collection<Address> listOfAddresses = new ArrayList<>();
	
	public Collection<Address> getListOfAddresses() { 
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
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