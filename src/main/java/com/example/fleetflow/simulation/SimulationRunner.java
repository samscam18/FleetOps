package com.example.fleetflow.simulation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fleetflow.model.DeliveryTask;
import com.example.fleetflow.model.Driver;
import com.example.fleetflow.service.DeliveryService;
import com.example.fleetflow.service.DriverService;

@Service
public class SimulationRunner {

    private final Dispatcher dispatcher;
    private final DeliveryService deliveryService;
    private final DriverService driverService;

    public SimulationRunner(Dispatcher dispatcher, DeliveryService deliveryService, DriverService driverService) {
        this.dispatcher = dispatcher;
        this.deliveryService = deliveryService;
        this.driverService = driverService;
    }

    public void startSimulation() {
        driverService.addDriver(new Driver("D1"));
        driverService.addDriver(new Driver("D2"));
        driverService.addDriver(new Driver("D3"));

        List<DeliveryTask> tasks = Arrays.asList(
                new DeliveryTask("PKG001", "Mumbai", 10),
                new DeliveryTask("PKG002", "Pune", 20),
                new DeliveryTask("PKG003", "Delhi", 30),
                new DeliveryTask("PKG004", "Bangalore", 40),
                new DeliveryTask("PKG005", "Hyderabad", 25)
        );

        tasks.forEach(deliveryService::addTask);

        dispatcher.dispatch();
    }
}
