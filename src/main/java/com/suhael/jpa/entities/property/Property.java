package com.suhael.jpa.entities.property;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "property")
public class Property implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    public Property(){}
}
