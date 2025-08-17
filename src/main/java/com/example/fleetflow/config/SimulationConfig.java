package com.example.fleetflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

@Configuration
public class SimulationConfig {

    // pool of worker threads for concurrent deliveries
    @Bean(destroyMethod = "shutdown")
    public ExecutorService deliveryExecutor() {
        int threads = Math.max(4, Runtime.getRuntime().availableProcessors());
        return Executors.newFixedThreadPool(threads);
    }
}
