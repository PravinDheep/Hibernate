package com.workouts.basichibernate1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
//Treat this class as Entity and needs to save it.
@Entity(name="USER_DETAILS1")
//@Table(name="USER_DETAILS1")
public class UserDetails {
	
	/*
	 *	Providing a name for @Entity, you providing a new name for entity itself, but by providing a name for
	 *  @Table annotation, you just providing a name for the table which is created for the entity while the
	 *  Entity name still remains with the default class name which is UserDetails. On using HQL we can know 
	 *  these. 
	 */
	@Id
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	//private LocalDateTime joinedDate;
	private String Address;
	
	@Lob
	private String description;
	
	@Transient
	private String notes;
	
	/*
	 * @Basic - Treat it as a field which should be persisted and apply the hibernate defaults. @Basic annotation can be ignored, 
	 * as it is assumed by default, but it can take parameters FetchType, Optional.
	 * Optional - Defines whether this attribute allows nulls. As long as the type is not primitive, hibernate
	 * takes this to mean that the underlying column should be NULLABLE.
	 * fetch - defaults to EAGER, EAGER is when the owner is fetched, LAZY when the attribute is accessed,
	 * Hibernate ignores this basic types unless you are using bytecode enhancement.
	 * 
	 * @Transient - Ignore the saving of database.
	 * @Temporal - Instead of saving in datetime(timestamp) format, we can specify to save in date or time 
	 * format using TemporalType.
	 * @Lob = Large objects, @Blob = Byte Stream Large objects, @Clob = Character array Large objects, in this case
	 * description is limited to 255 characters, if we need to control the description value if it crosses more
	 * than 255 characters, we can use these.
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
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}