package com.bookcdstore.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property {
	
    @Id
    @GeneratedValue
    @Column(name="id")
	private int propertyId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="landlord_fk")
    private Landlord landlord;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="property")
    private Set<Room> rooms;
	
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public Landlord getLandlord() {
		return landlord;
	}
	public void setLandlord(Landlord landlord) {
		this.landlord = landlord;
	}
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

}
