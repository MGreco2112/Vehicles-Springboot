package com.vehicles.VehiclesProject.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;
    private Integer numberOfWheels;
    private String engine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle() {

    }

    public Vehicle(String type, int numberOfWheels, String engine) {
        this.type = type;
        this.numberOfWheels = numberOfWheels;
        this.engine = engine;
    }

    public Vehicle(Long id, String type, int numberOfWheels, String engine) {
        this.id = id;
        this.type = type;
        this.numberOfWheels = numberOfWheels;
        this.engine = engine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
