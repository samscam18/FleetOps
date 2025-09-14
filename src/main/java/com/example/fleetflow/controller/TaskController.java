package com.example.fleetflow.controller;

import com.example.fleetflow.model.DeliveryTask;
import com.example.fleetflow.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody DeliveryTask task) {
        taskService.addTask(task);
        return ResponseEntity.ok("📦 Task added: " + task.getPackageId());
    }

    @GetMapping
    public List<DeliveryTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/pending")
    public List<DeliveryTask> getPendingTasks() {
        return taskService.getPendingTasks();
    }
}
