package com.suhael.jpa.entities.property;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "searchCriteria")
public class SearchCriteria implements Serializable {

    @Id
    @GeneratedValue
    private int criteriaId;
    private int minRooms;
    private int maxRooms;
    private int maxRent;

    public SearchCriteria(){}

    public int getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(int criteriaId) {
        this.criteriaId = criteriaId;
    }

    public int getMinRooms() {
        return minRooms;
    }

    public void setMinRooms(int minRooms) {
        this.minRooms = minRooms;
    }

    public int getMaxRooms() {
        return maxRooms;
    }

    public void setMaxRooms(int maxRooms) {
        this.maxRooms = maxRooms;
    }

    public int getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(int maxRent) {
        this.maxRent = maxRent;
    }
}
