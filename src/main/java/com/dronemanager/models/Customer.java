package com.dronemanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer_tbl")
public class Customer extends User{

    @Column(name = "organization")
    private String organization;

    public Customer(String id, String firstName, String lastName, String dob, String organization) {
        super(id, firstName, lastName, dob);
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        organization = organization;
    }
}
