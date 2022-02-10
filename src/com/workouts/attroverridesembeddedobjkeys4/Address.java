package com.workouts.attroverridesembeddedobjkeys4;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	/* After using Column, no matter where ever this address object is used, it will carry this COLUMN names
	 * and displays it for all places, say homeAddress and officeAddress, both will be using these
	 * configured column names. 
	 */
	
	/*
	 * In order to mark this has a value type and in order to tell Hibernate not to create a separate
	 * table for them, need to use the annotation @Embeddable.
	 */
	@Column(name="STREET_NAME")
	private String street;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="PIN_CODE")
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