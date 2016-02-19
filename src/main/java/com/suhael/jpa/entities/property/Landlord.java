package com.suhael.jpa.entities.property;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "landlord")
public class Landlord extends Person implements Serializable {

    @OneToMany(fetch= FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy="landlord")
    private Set<Property> properties;

    public Landlord(){}

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }
}
