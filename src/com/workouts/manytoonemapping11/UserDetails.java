package com.workouts.manytoonemapping11;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="MANYTOONEMAPPING11")
public class UserDetails {
	/*
	 * @ManyToOne is the most common association, having a direct equivalent 
	 * in the relational database as well (e.g. foreign key), and so it 
	 * establishes a relationship between a child entity and a parent.
	 * 
	 * @OneToMany(mappedBy="propertyname") - It displays where you want the mapping to 
	 * happen, in this case I want the mapping to happen in the Vehicle table, I don't want 
	 * the mapping in a separate table. In the vehicle table, based on the joincolumn name, it
	 * will create a userdetails column in the Vehicle table itself.
	 */
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column(name="USER_NAME")
	private String userName;

	@OneToMany(mappedBy="userdetails")
	//@JoinTable(joinColumns = @JoinColumn(name="USERID"), inverseJoinColumns = @JoinColumn(name="VEHICLEID")) //By default, UserDetails_userId, Vehicle_vehicleId
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
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