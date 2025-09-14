package com.example.fleetflow.service;

import com.example.fleetflow.model.DeliveryTask;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<DeliveryTask> tasks = new ArrayList<>();

    public void addTask(DeliveryTask task) {
        tasks.add(task);
    }

    public List<DeliveryTask> getAllTasks() {
        return tasks;
    }

    public List<DeliveryTask> getPendingTasks() {
        return tasks.stream()
                .filter(t -> t.getAssignedDriver() == null)
                .toList();
    }
}
