package com.example.fleetflow.simulation;

import com.example.fleetflow.model.DeliveryTask;

public class VehicleWorker implements Runnable {

    private final DeliveryTask task;

    public VehicleWorker(DeliveryTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " delivering package " + task.getPackageId() +
                " to " + task.getDestination() +
                " (" + task.getDistanceKm() + " km)");
        try {
            Thread.sleep(task.getDistanceKm() * 100L); // simulate travel
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Package " + task.getPackageId() + " delivered by " +
                Thread.currentThread().getName());
    }
}
