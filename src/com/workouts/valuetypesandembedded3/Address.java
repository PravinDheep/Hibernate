package com.workouts.valuetypesandembedded3;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	/*
	 * In order to mark this has a value type and in order to tell Hibernate NOT to create a separate
	 * table for them, need to use the annotation @Embeddable.
	 */
	private String street;
	private String city;
	private String state;
	private String pincode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}