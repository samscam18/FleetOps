package com.example.fleetflow.controller;

import java.util.List;
import java.util.stream.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetflow.model.DeliveryTask;
import com.example.fleetflow.service.DeliveryService;
import com.example.fleetflow.simulation.Dispatcher;


@RestController
@RequestMapping("/dispatch")
public class DispatchController {

    private final Dispatcher dispatcher;
    private final DeliveryService deliveryService;



    public DispatchController(Dispatcher dispatcher, DeliveryService deliveryService) {
        this.dispatcher = dispatcher;
        this.deliveryService = deliveryService;
    }

   @PostMapping("/run")
public String dispatchTasks(@RequestBody List<DeliveryTask> tasks) {
    // Simulate dispatch
    dispatcher.dispatchTasks(tasks);

    // Also save each task
    tasks.forEach(deliveryService::addTask);

    return "🚚 Tasks dispatched and saved successfully!";
}


    @GetMapping("/tasks")
    public List<DeliveryTask> getAllTasks() {
        return deliveryService.getAllTasks();
    }
    



}
