package com.example.fleetflow.model;

public enum DeliveryStatus {
    PENDING,        // created but not assigned
    ASSIGNED,       // assigned to a driver, waiting to start
    IN_PROGRESS,    // driver "on the way"
    DELIVERED,      // completed successfully
    FAILED 
}
