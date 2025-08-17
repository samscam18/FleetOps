package com.example.fleetflow.model;

public class DeliveryTask {
    private String id;
    private String destination;
    private int distance;  // ✅ Missing before
    private String status = "PENDING";
    private String assignedDriver;

    public DeliveryTask(String id, String destination, int distance) {
        this.id = id;
        this.destination = destination;
        this.distance = distance;
    }
    


    public String getDestination() {
        return destination;
    }
    
    // ✅ Needed methods
    public String getPackageId() {
        return id;
    }

    public int getDistanceKm() {
        return distance;
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
