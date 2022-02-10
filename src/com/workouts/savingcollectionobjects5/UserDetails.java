package com.workouts.savingcollectionobjects5;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Treat this class as Entity and needs to save it.
@Entity
@Table(name="USER_DETAILS_SAVINGCOLLECTIONS5")
public class UserDetails {
	
	/* 
	 * What if I need a collection, what if I do not know how many objects I need, I want a 
	 * collection to be a member variables of this User class. 
	 * Eg: private Set<Address> listofAddresses = new HashSet(); Note that we cannot use the
	 * implementation class in the place of Set, because of the lazy and fetch types.
	 * Set<Address> listofAddresses = new HashSet(); - Now the annotation that I need to make
	 * to hibernate, that this is actually to be treated as a List and I want the list to be
	 * saved. The annotation that needs to be used is @ElementCollection.
	 * @ElementCollection - To mark the entire collection to be persisted by hibernate. First it  
	 * inserts user details but doesn't insert the collection objects and then in a separate 
	 * table(userdetils_collectionobjectname) it inserts the collection elements.
	 */
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId; //natural key // private LoginUser userId; @EmbeddedId - LoginUser is a combination of keys to form a primary key userId, Use @EmbeddedId in such cases.
	@Column(name="USER_NAME")
	private String userName;
	
	@ElementCollection
	private Set<Address> listOfAddresses = new HashSet<>();  // Only Set should be used in Set<Address>, hashset cannot be used, due to the use of fetch type lazy and eager.
	
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