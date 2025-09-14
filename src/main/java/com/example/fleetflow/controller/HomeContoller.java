package com.example.fleetflow.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeContoller {
    @GetMapping("/")
    public String home() {
        return "FleetFlow App is running 🚀";
    }
    
}
