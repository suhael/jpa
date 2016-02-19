package com.suhael.jpa.entities.property;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tenant")
public class Tenant extends Person implements Serializable {

    @OneToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name="criteria_fk")
    private SearchCriteria searchCriteria;

    public Tenant(){}

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
