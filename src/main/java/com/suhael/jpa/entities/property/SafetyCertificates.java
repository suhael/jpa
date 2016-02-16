package com.suhael.jpa.entities.property;

import com.suhael.jpa.entities.property.enums.SafetyCertificateType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "safetyCert")
public class SafetyCertificates implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private SafetyCertificateType safetyCertificateType;
    private Date expiryDate;


    public SafetyCertificates(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SafetyCertificateType getSafetyCertificateType() {
        return safetyCertificateType;
    }

    public void setSafetyCertificateType(SafetyCertificateType safetyCertificateType) {
        this.safetyCertificateType = safetyCertificateType;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
