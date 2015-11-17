package com.example;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="test")
public class Test implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8118429535275267356L;
	@EmbeddedId
	private TestPK pk;
	private String name;
	
	public Test(){
		
	}


	public TestPK getPk() {
		return pk;
	}


	public void setPk(TestPK pk) {
		this.pk = pk;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
