package com.example.fleetflow.model;



public class DeliveryTask {
    private String packageId;
    private String destination;
    private int distanceKm;
    private Route route;
    private long etaMinutes;
    
    public DeliveryTask(String packageId, String destination, int distanceKm) {
        this.packageId = packageId;
        this.destination = destination;
        this.distanceKm = distanceKm;
    }

    public String getPackageId() { return packageId; }
    public String getDestination() { return destination; }
    public int getDistanceKm() { return distanceKm; }

    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }

    public long getEtaMinutes() { return etaMinutes; }
    public void setEtaMinutes(long etaMinutes) { this.etaMinutes = etaMinutes; }
}
