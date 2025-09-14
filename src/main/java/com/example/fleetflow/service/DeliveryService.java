package com.example.fleetflow.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fleetflow.model.DeliveryTask;

@Service
public class DeliveryService {

    private final List<DeliveryTask> tasks = new ArrayList<>();

    public void addTask(DeliveryTask task) {
        tasks.add(task);
    }

    public List<DeliveryTask> getAllTasks() {
        return tasks;
    }

    public List<DeliveryTask> getPendingTasks() {
        return tasks.stream()
                .filter(t -> "PENDING".equalsIgnoreCase(t.getStatus()))
                .collect(Collectors.toList());
    }

    public void markAssigned(DeliveryTask task, String driverId) {
        task.setStatus("ASSIGNED");
        task.setAssignedDriver(driverId);
    }

    public void markInProgress(DeliveryTask task) {
        task.setStatus("IN_PROGRESS");
    }

    public void markDelivered(DeliveryTask task) {
        task.setStatus("DELIVERED");
    }

    public void markFailed(DeliveryTask task) {
        task.setStatus("FAILED");
    }
}
