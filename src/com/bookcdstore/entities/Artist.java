package com.bookcdstore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="artist")
public class Artist {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "createdByArtists")
    private List<CD> appearsOnCDs;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Artist() {
    }

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CD> getAppearsOnCDs() {
        return appearsOnCDs;
    }

    public void setAppearsOnCDs(List<CD> appearsOnCDs) {
        this.appearsOnCDs = appearsOnCDs;
    }

    public void appearsOn(CD cd) {
        if (appearsOnCDs == null)
            appearsOnCDs = new ArrayList<CD>();
        appearsOnCDs.add(cd);
    }

}