package com.example.fleetflow.simulation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.fleetflow.model.DeliveryTask;
import com.example.fleetflow.model.Driver;
import com.example.fleetflow.model.Vehicle;
import com.example.fleetflow.service.DeliveryService;
import com.example.fleetflow.service.DriverService;
import com.example.fleetflow.service.VehicleService;


@Service
public class Dispatcher {

    private final DriverService driverService;
    private final DeliveryService deliveryService;
    private final VehicleService vehicleService;

    public Dispatcher(DriverService driverService, DeliveryService deliveryService, VehicleService vehicleService) {
        this.driverService = driverService;
        this.deliveryService = deliveryService;
        this.vehicleService = vehicleService;
    }

    public void dispatch() {
        List<DeliveryTask> tasks = deliveryService.getAllTasks();
        dispatchTasks(tasks);
    }

    public void dispatchTasks(List<DeliveryTask> tasks) {
        for (DeliveryTask task : tasks) {
            if ("PENDING".equals(task.getStatus())) { // ✅ only assign new ones
                Optional<Driver> driverOpt = driverService.getAvailableDriver();
                Optional<Vehicle> vehicleOpt = vehicleService.getAvailableVehicles().stream().findFirst();

                if (driverOpt.isPresent() && vehicleOpt.isPresent()) {
                    Driver driver = driverOpt.get();
                    Vehicle vehicle = vehicleOpt.get();

                    // Reserve resources
                    driverService.reserve(driver);
                    vehicleService.reserveVehicle(vehicle.getId()); // ✅ FIXED

                    // Update task info
                    task.setAssignedDriver(driver.getId());
                    task.setAssignedVehicle(vehicle.getId());
                    task.setStatus("IN_PROGRESS");

                    System.out.println("🚚 Assigned Driver " + driver.getId() +
                                       " + Vehicle " + vehicle.getId() +
                                       " to Task " + task.getId());
                } else {
                    System.out.println("⚠️ No available resources for Task " + task.getId());
                }
            }
        }
    }
}
