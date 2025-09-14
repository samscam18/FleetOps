package com.example.fleetflow.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.fleetflow.model.Driver;

@Service
public class DriverService {

    private final List<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }

    
    public List<Driver> getAvailableDrivers() {
        return drivers.stream()
                .filter(Driver::isAvailable)
                .toList();
    }


    public Optional<Driver> getAvailableDriver() {
        return drivers.stream()
                .filter(Driver::isAvailable)
                .findFirst();
    }

    
    public void reserve(Driver driver) {
        driver.setAvailable(false);
    }

    public void releaseDriver(String id) {
        Optional<Driver> driver = drivers.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        driver.ifPresent(d -> d.setAvailable(true));
    }
}
