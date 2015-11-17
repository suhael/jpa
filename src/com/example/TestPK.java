package com.example;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

@Embeddable
public class TestPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7186886253395350019L;

	public TestPK(){
		
	}
	
	public TestPK(int value){
		this.id = value;
	}
	
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
