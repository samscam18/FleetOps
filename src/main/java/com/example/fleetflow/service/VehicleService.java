package com.example.fleetflow.service;

import com.example.fleetflow.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public VehicleService() {
        vehicles.add(new Vehicle("V001", "Mumbai", 50));
        vehicles.add(new Vehicle("V002", "Pune", 30));
        vehicles.add(new Vehicle("V003", "Delhi", 40));
    }

    public List<Vehicle> getAvailableVehicles() {
        return vehicles.stream()
                .filter(Vehicle::isAvailable)
                .toList();
    }
}
