package com.vehicles.VehiclesProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private final Map<Long, Vehicle> rentedVehicles = new HashMap<>();

    public Customer() {

    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle addVehicle(Long id, Vehicle newVehicle) {
        rentedVehicles.put(id, newVehicle);

        return newVehicle;
    }

    public List<Vehicle> getVehicles() {
        return new ArrayList<Vehicle>(rentedVehicles.values());
    }
}
