package com.example.fleetflow.model;

public class Vehicle {
    private String id;
    private String location;
    private int capacity;
    private boolean available;
    private final int avgSpeedKmph;

    public Vehicle(String id, String location, int capacity) {
        this(id, location, capacity, 40); // default 40 km/h
    }

    public Vehicle(String id, String location, int capacity, int avgSpeedKmph) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
        this.available = true;
        this.avgSpeedKmph = avgSpeedKmph;
    }

    public String getId() { return id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getCapacity() { return capacity; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public int getAvgSpeedKmph() { return avgSpeedKmph; }
}
