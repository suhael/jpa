package com.bookcdstore.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "landlord")
public class Landlord {
	
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.TABLE)
	private int personId;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="landlord")
	private Set<Property> properties;
	
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

}
