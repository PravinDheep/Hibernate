package com.workouts.singletablestrategyinheritance15;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE")
public class TwoWheeler extends Vehicle {
	/*
	 * By default, DType column will have the class name as the value, we can use
	 * @DiscriminatorValue("BIKE") to re-configure it.
	 */
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
	
}
