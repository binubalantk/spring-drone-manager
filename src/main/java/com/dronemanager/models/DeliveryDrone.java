package com.dronemanager.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DELIVERY")
public class DeliveryDrone extends Drone {
    @Column(name = "service_vendor")
    private String serviceVendor;

    public DeliveryDrone(String id, String name, String serviceVendor) {
        super(id, name);
        this.serviceVendor = serviceVendor;
    }

    public String getServiceVendor() {
        return serviceVendor;
    }

    public void setServiceVendor(String serviceVendor) {
        this.serviceVendor = serviceVendor;
    }
}
