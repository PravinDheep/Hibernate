package com.workouts.singletablestrategyinheritance15;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEHICLEDTYPE", 
		discriminatorType=DiscriminatorType.STRING)
@Table(name="SINGLETABLESTRATEGYINHERITANCE15")
public class Vehicle {
	/*
	 * Creates a DType(discriminator) column and stores all the parent and child class names in
	 * a single table Vehicle. We can configure the Dtype column names and values using 
	 * @DiscriminatorColumn(name="VEHICLEDTYPE", 
		discriminatorType=DiscriminatorType.STRING)
	 * 
	 * Even if we don't declare @Inheritance(strategy=InheritanceType.SINGLE_TABLE), the hibernate
	 * performs single table strategy only.
	 */
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleName;
	
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