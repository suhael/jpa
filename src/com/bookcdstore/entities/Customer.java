package com.bookcdstore.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@ExcludeSuperclassListeners()
@Entity
@NamedQueries({
    @NamedQuery(name = "findAll", query = "select c from Customer c"),
    @NamedQuery(name = Customer.FIND_ALL, query = "select c from Customer c"),
    @NamedQuery(name = "findVincent", query = "select c from Customer c where c.firstName = 'Vincent'"),
    @NamedQuery(name = "findWithParam", query = "select c from Customer c where c.firstName = :fname")
})
@NamedNativeQueries({
    @NamedNativeQuery(name = "findAllNative", query = "select * from customer", resultClass = Customer.class)
})
public class Customer extends Person implements Serializable{

	private static final long serialVersionUID = -9061063018250725317L;

	public static final String FIND_ALL = "Customer.findAll";

    // ======================================
    // =             Attributes             =
    // ======================================
    private String email;
    private String phoneNumber;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "address_fk")
    private Address address;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth, Date creationDate) {
        super(firstName, lastName);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.creationDate = creationDate;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}