package com.example.fleetflow.model;

public class DeliveryTask {
    private String id;
    private String destination;
    private int distance;
    private String status = "PENDING";
    private String assignedDriver;
    private String assignedVehicle;

    // ✅ No-arg constructor (Jackson needs this)
    public DeliveryTask() {}

    // Existing constructor
    public DeliveryTask(String id, String destination, int distance) {
        this.id = id;
        this.destination = destination;
        this.distance = distance;
    }

    public String getAssignedVehicle(){
        return assignedVehicle;
    }

    public void setAssignedVehicle(String asignedVehicle){
        this.assignedVehicle = assignedVehicle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getPackageId() {
        return id;
    }

    public String getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(String assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
