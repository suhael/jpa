package com.bookcdstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	
    @Id
    @GeneratedValue
    @Column(name="id")
	private int roomId;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="property_fk")
	private Property property;
    
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}

}
