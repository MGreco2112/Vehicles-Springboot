package com.vehicles.VehiclesProject;

public class Vehicle {
    private Long id;
    private String type;
    private int numberOfWheels;
    private Engine engine;

    public Vehicle(Long id, String type, int numberOfWheels, Engine engine) {
        this.id = id;
        this.type = type;
        this.numberOfWheels = numberOfWheels;
        this.engine = engine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
