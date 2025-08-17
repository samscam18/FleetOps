package com.example.fleetflow.service;

import com.example.fleetflow.model.Driver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private final List<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    // Return a single available driver (first one found)
    public Driver getAvailableDriver() {
        return drivers.stream()
                .filter(Driver::isAvailable)
                .findFirst()
                .orElse(null);
    }

    // If you still need all available drivers
    public List<Driver> getAvailableDrivers() {
        return drivers.stream()
                .filter(Driver::isAvailable)
                .collect(Collectors.toList());
    }

    public void reserve(Driver driver) {
        driver.setAvailable(false);
    }

    public void release(Driver driver) {
        driver.setAvailable(true);
    }
}
