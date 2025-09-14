package com.example.fleetflow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fleetflow.model.Vehicle;

@Service
public class VehicleService {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public VehicleService() {
        vehicles.add(new Vehicle("V001", "Mumbai", 50));
        vehicles.add(new Vehicle("V002", "Pune", 30));
        vehicles.add(new Vehicle("V003", "Delhi", 40));
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicles;
    }

    public void reserveVehicle(String id){
        vehicles.stream()
                .filter(v -> v.getId().equals(id) && v.isAvailable())
                .findFirst()
                .ifPresent(v -> v.setAvailable(false));
                
    }

    
    public List<Vehicle> getAvailableVehicles() {
        return vehicles.stream()
                .filter(Vehicle::isAvailable)
                .toList();
    }

    public void releaseVehicle(String id) {
        vehicles.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .ifPresent(v -> v.setAvailable(true));
    }

}
