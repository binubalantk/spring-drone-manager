package com.dronemanager.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "drone_tbl")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "drone_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "Drone")
public class Drone {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @Column(name = "drone_id", unique = true, nullable = false)
    private String id;

    @Column(name = "drone_name", nullable = false)
    private String name;

    public Drone(String id, String name) {
        this.id = id;
        this.name = name;
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
}
