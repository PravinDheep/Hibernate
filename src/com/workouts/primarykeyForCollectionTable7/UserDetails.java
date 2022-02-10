package com.workouts.primarykeyForCollectionTable7;

import java.util.ArrayList;
import java.util.Collection;
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

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS_PRIMARYKEYFORCOLLECTIONTABLE7")
public class UserDetails {
	/*
	 * In order to define a ID(index) for collection, we cannot use Set as it doesn't support index, hence we will use ArrayList. 
	 * @CollectionId is used for defining the ID(index), @CollectionId is from hibernate and not persistence.
	 */
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS_COLLECTION7", 
			joinColumns=@JoinColumn(name="USER_ID_FOREIGNKEY")) // @JoinTable is used to change the table name(by default object_property name) and primary key column
	@GenericGenerator(name="hilo-gener", strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID")}, generator = "hilo-gener", type= @Type(type="int"))
	private Collection<Address> listOfAddresses = new ArrayList<>(); // Here, we used Collection is because soon we will see about fetch,eager.
	
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