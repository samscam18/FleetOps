package com.example.fleetflow;

import org.springframework.boot.CommandLineRunner;  // ✅ correct import
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.fleetflow.simulation.SimulationRunner;


@SpringBootApplication
public class FleetFlowApplication implements CommandLineRunner {

    private final SimulationRunner simulationRunner;

    public FleetFlowApplication(SimulationRunner simulationRunner) {
        this.simulationRunner = simulationRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(FleetFlowApplication.class, args);
    }

    @Override
    public void run(String... args) {
        simulationRunner.startSimulation(); // ✅ matches your method name
    }
}
