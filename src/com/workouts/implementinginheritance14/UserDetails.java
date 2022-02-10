package com.workouts.implementinginheritance14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="IMPLEMENTINGINHERITANCE14")
public class UserDetails {
	/*
	 * The @ManyToMany association requires a link table that joins two entities. 
	 * Like the @OneToMany association, @ManyToMany can be either unidirectional or 
	 * bidirectional.
	 * 
	 * Cascade applicable to all the Associations like onetoone, onetomany etc.
	 * ALL - cascades all entity state transitions
     * PERSIST - cascades the entity persist operation.
	 * MERGE - cascades the entity merge operation.
	 * REMOVE - cascades the entity remove operation.
	 * REFRESH - cascades the entity refresh operation.
	 * DETACH - cascades the entity detach operation.
	 * SAVE_UPDATE - cascades the entity saveOrUpdate operation.
	 * REPLICATE - cascades the entity replicate operation.
	 * LOCK - cascades the entity lock operation.
	 * 
	 * When saving the parent, dependent child objects also gets saved. Same for remove.
	 * 
	 */
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column(name="USER_NAME")
	private String userName;

	@OneToMany(cascade=CascadeType.ALL)
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