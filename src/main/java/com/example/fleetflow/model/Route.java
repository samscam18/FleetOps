package com.example.fleetflow.model;

public class Route {
    private final String origin;
    private final String destination;
    private final int distanceKm;

    public Route(String origin, String destination, int distanceKm) {
        this.origin = origin;
        this.destination = destination;
        this.distanceKm = distanceKm;
    }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public int getDistanceKm() { return distanceKm; }

    @Override
    public String toString() {
        return origin + " → " + destination + " (" + distanceKm + " km)";
    }

    
}
