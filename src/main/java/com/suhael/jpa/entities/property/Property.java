package com.suhael.jpa.entities.property;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "property")
public class Property implements Serializable {

    @Id
    @GeneratedValue
    private int propertyId;

    @OneToOne(cascade = {CascadeType.REMOVE}, fetch=FetchType.LAZY)
    @JoinColumn(name="address_fk")
    private Address address;

    @ManyToOne
    @JoinColumn(name="landlord_fk")
    private Landlord landlord;

    public Property(){}

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }
}
