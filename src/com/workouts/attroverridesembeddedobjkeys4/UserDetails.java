package com.workouts.attroverridesembeddedobjkeys4;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
//Treat this class as Entity and needs to save it.
@Entity
@Table(name="USER_DETAILS_ATTRIBUTEOVERRIDES4")
public class UserDetails {
	
	/*
	 * Say we have homeAddress and officeAddress, homeAddress will have the @Column names configured in
	 * the Address object, but even the officeAddress table will have the @Column names
	 * provided in the Address object, no it cannot create, there is already a column with that name, we 
	 * can override the default name when you are embedding, we can override in the homeAddress, another
	 * thing is we can give unique column names, we need to differentiate homeAddress columns and officeAddress 
	 * column names, for this we use @AttributeOverride.
	 * 
	 * One special case is that, the userId primary key, can be an embedded object. Assume a few member variables
	 * put together(combination of member variables forms a primary key) forms a primary key, in that case can 
	 * make private User somename, in that case we cannot use @ID annotation and cannot use @Embedded annotation, 
	 * we will use @EmbeddedId annotation. Even other annotations like @AttributeOverrides still works good.
	 * Note, generatedvalue will not work in this case.
	 */
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId; //natural key
	@Column(name="USER_NAME")
	private String userName;
	
	/*
	 * You can also have another annotation here, this annotation says the object is an Embedded object.This is
	 * not mandatory, if the referring class is marked as @Embeddable. 
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pincode", column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	/*
	 * public Address getAddress() { return address; } public void
	 * setAddress(Address address) { this.address = address; }
	 */

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