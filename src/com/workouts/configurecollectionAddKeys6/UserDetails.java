package com.workouts.configurecollectionAddKeys6;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
@Entity
@Table(name="USER_DETAILS_CONFIGURINGCOLLECTIONS6")
public class UserDetails {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	
	@ElementCollection
	
	/*When you add the collection, by default the primary key is UserDetails_USER_ID, but when you 
	 *want to change, you use @JoinColumn USER_ID_PRIMARYKEY
	 */
	@JoinTable(name="USER_ADDRESS_COLLECTIONTABLE6",
  	joinColumns=@JoinColumn(name="USER_ID_PRIMARYKEY"))
	// To change the table name(by default classname_propertyname) and primary key column
	private Set<Address> listOfAddresses = new HashSet<>();
	
	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	
	public void setListOfAddresses(Set<Address> listOfAddresses) {
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