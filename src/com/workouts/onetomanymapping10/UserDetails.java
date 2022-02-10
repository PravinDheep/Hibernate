package com.workouts.onetomanymapping10;

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
@Table(name="ONETOMANYMAPPING10")
public class UserDetails {
	/*
	 * The @OneToMany association links a parent entity with one or more child entities. If the 
	 * @OneToMany doesn’t have a mirroring @ManyToOne association on the child side, the @OneToMany 
	 * association is unidirectional. If there is a @ManyToOne association on the child side, the 
	 * @OneToMany association is bidirectional and the application developer can navigate this 
	 * relationship from both ends.
	 */
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column(name="USER_NAME")
	private String userName;

	@OneToMany
	@JoinTable(joinColumns = @JoinColumn(name="USERID"), 
			   inverseJoinColumns = @JoinColumn(name="VEHICLEID")) //By default, UserDetails_userId, Vehicle_vehicleId
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