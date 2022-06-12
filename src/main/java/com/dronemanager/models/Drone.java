package com.dronemanager.models;

import com.dronemanager.constants.DroneType;

public class Drone {
    private String id;
    private String name;
    private DroneType droneType;

    public Drone(String id, String name, DroneType droneType) {
        this.id = id;
        this.name = name;
        this.droneType = droneType;
    }

    public Drone() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DroneType getDroneType() {
        return droneType;
    }

    public void setDroneType(DroneType droneType) {
        this.droneType = droneType;
    }
}
