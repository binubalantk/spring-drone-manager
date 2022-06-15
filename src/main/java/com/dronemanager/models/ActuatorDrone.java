package com.dronemanager.models;

import com.dronemanager.constants.ActuatorType;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "ACTUATOR")
public class ActuatorDrone extends Drone{
    @Column(name = "actuator_type")
    @Enumerated(EnumType.STRING)
    private ActuatorType actuatorType;

    public ActuatorType getActuatorType() {
        return actuatorType;
    }

    public void setActuatorType(ActuatorType actuatorType) {
        this.actuatorType = actuatorType;
    }
}
