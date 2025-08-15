package com.example.fleetflow.service;

import com.example.fleetflow.model.Route;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RouteService {

    // Very small mock distance matrix (km). Add more as you like.
    private final Map<String, Map<String, Integer>> distances = new HashMap<>();

    public RouteService() {
        // Mumbai
        put("Mumbai","Pune",149);
        put("Mumbai","Delhi",1447);
        put("Mumbai","Bangalore",984);
        put("Mumbai","Hyderabad",709);

        // Pune
        put("Pune","Mumbai",149);
        put("Pune","Delhi",1460);
        put("Pune","Bangalore",839);
        put("Pune","Hyderabad",560);

        // Delhi
        put("Delhi","Mumbai",1447);
        put("Delhi","Pune",1460);
        put("Delhi","Bangalore",2150);
        put("Delhi","Hyderabad",1560);

        // Bangalore
        put("Bangalore","Mumbai",984);
        put("Bangalore","Pune",839);
        put("Bangalore","Delhi",2150);
        put("Bangalore","Hyderabad",570);

        // Hyderabad
        put("Hyderabad","Mumbai",709);
        put("Hyderabad","Pune",560);
        put("Hyderabad","Delhi",1560);
        put("Hyderabad","Bangalore",570);
    }

    private void put(String a, String b, int km) {
        distances.computeIfAbsent(a, k -> new HashMap<>()).put(b, km);
    }

    /** Build a Route. If unknown, fallback to 50km so the sim keeps running. */
    public Route getRoute(String origin, String destination) {
        int km = distances.getOrDefault(origin, Map.of())
                          .getOrDefault(destination, 50);
        return new Route(origin, destination, km);
    }

    /** Compute ETA minutes given distance and speedKmph. */
    public long estimateEtaMinutes(int distanceKm, int speedKmph) {
        if (speedKmph <= 0) speedKmph = 40;
        double hours = (double) distanceKm / speedKmph;
        return Math.max(1, Math.round(hours * 60));
    }
}
