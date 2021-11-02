package com.vehicles.VehiclesProject.vehicle;

import com.vehicles.VehiclesProject.vehicle.Vehicle;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final AtomicLong idCount = new AtomicLong();
    private final Map<Long, Vehicle> vehicles = new HashMap<>();

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

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle updateData) {
        Vehicle vehicle = vehicles.get(id);

        if (vehicle == null) {
            return vehicle;
        }

        if (updateData.getType() != null) {
            vehicle.setType(updateData.getType());
        }
        if (updateData.getNumberOfWheels() != null) {
            vehicle.setNumberOfWheels(updateData.getNumberOfWheels());
        }
        if (updateData.getEngine() != null) {
            vehicle.setEngine(updateData.getEngine());
        }

        return vehicle;
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicles.remove(id);
    }

}
