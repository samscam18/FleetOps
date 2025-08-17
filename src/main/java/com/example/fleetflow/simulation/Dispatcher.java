package com.example.fleetflow.simulation;

import com.example.fleetflow.model.DeliveryTask;
import com.example.fleetflow.model.Driver;
import com.example.fleetflow.service.DeliveryService;
import com.example.fleetflow.service.DriverService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dispatcher {

    private final DeliveryService deliveryService;
    private final DriverService driverService;

    public Dispatcher(DeliveryService deliveryService, DriverService driverService) {
        this.deliveryService = deliveryService;
        this.driverService = driverService;
    }

    /**
     * Assigns pending delivery tasks to available drivers.
     */
    public void dispatch() {
        List<DeliveryTask> pendingTasks = deliveryService.getPendingTasks();

        for (DeliveryTask task : pendingTasks) {
            Driver driver = driverService.getAvailableDriver();
            if (driver != null) {
                deliveryService.markAssigned(task, driver.getId());
                driverService.reserve(driver);
                System.out.println("✅ Task " + task.getPackageId() +
                        " assigned to Driver " + driver.getId());
            } else {
                System.out.println("⚠️ No available drivers for task " + task.getPackageId());
            }
        }
    }
}
