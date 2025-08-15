package com.example.fleetflow.service;

import com.example.fleetflow.model.DeliveryTask;
import com.example.fleetflow.simulation.Dispatcher;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SimulationRunner {

    private final Dispatcher dispatcher;

    public SimulationRunner(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void startSimulation() {
        List<DeliveryTask> tasks = Arrays.asList(
                new DeliveryTask("PKG001", "Mumbai", 10),
                new DeliveryTask("PKG002", "Pune", 20),
                new DeliveryTask("PKG003", "Delhi", 30),
                new DeliveryTask("PKG004", "Bangalore", 40),
                new DeliveryTask("PKG005", "Hyderabad", 25)
        );
        dispatcher.dispatchTasks(tasks);
    }
}
