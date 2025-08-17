package com.example.fleetflow.model;

public class Driver {
    private String id;
    private String name;
    private boolean available = true;
    private String currentLocation;

    // ✅ Constructors
    public Driver(String id) {
        this.id = id;
    }

    public Driver(String id, String name, String currentLocation) {
        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = true;
    }

    // ✅ Getters and setters
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Driver{id='" + id + "', name='" + name + "', available=" + available + "}";
    }
}
