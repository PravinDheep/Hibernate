package com.workouts.singletablestrategyinheritance15;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")
public class FourWheeler extends Vehicle {
	/*
	 * By default, DType column will have the class name as the value, we can use
	 * @DiscriminatorValue("CAR") to re-configure it.
	 */
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}	
