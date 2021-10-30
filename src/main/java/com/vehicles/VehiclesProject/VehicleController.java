package com.vehicles.VehiclesProject;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private AtomicLong idCount = new AtomicLong();
    private Map<Long, Vehicle> vehicles = new HashMap<>();

    public VehicleController() {
        Vehicle newVehicle = new Vehicle( "Car", 4, "Gas");

        newVehicle.setId(idCount.incrementAndGet());

        vehicles.put(idCount.get(), newVehicle);
    }

    @GetMapping
    public List<Vehicle> all() {
        return new ArrayList<Vehicle>(vehicles.values());
    }

    @PostMapping
    public Vehicle newVehicle(@RequestBody Vehicle newVehicle) {

        Long id = idCount.incrementAndGet();

        newVehicle.setId(id);

        vehicles.put(id, newVehicle);

        return newVehicle;
    }

    @GetMapping("/{id}")
    public Vehicle vehicle(@PathVariable Long id) {
        return vehicles.get(id);
    }

}
