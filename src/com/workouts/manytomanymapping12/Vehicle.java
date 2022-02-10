package com.workouts.manytomanymapping12;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleName;
	
	@ManyToMany(mappedBy="vehicle")
	private Collection<UserDetails> userdetails = new ArrayList<>();
	
	public Collection<UserDetails> getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Collection<UserDetails> userdetails) {
		this.userdetails = userdetails;
	}

	public int getVehicleId() {
		return vehicleId;
	}
	
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}