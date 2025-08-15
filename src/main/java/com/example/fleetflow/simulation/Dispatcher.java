package com.example.fleetflow.simulation;

import com.example.fleetflow.model.DeliveryTask;
import com.example.fleetflow.model.Route;
import com.example.fleetflow.model.Vehicle;
import com.example.fleetflow.service.RouteService;
import com.example.fleetflow.service.VehicleService;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class Dispatcher {

    private final VehicleService vehicleService;
    private final RouteService routeService;

    public Dispatcher(VehicleService vehicleService, RouteService routeService) {
        this.vehicleService = vehicleService;
        this.routeService = routeService;
    }

    public void dispatchTasks(List<DeliveryTask> tasks) {
        for (DeliveryTask task : tasks) {
            Optional<Vehicle> sameCity = vehicleService.getAvailableVehicles().stream()
                    .filter(v -> v.getLocation().equalsIgnoreCase(task.getDestination()))
                    .findFirst();

            Vehicle vehicle = sameCity.orElseGet(() ->
                    vehicleService.getAvailableVehicles().stream()
                            // (Optional) put your own selection strategy here
                            .min(Comparator.comparing(Vehicle::getId))
                            .orElse(null)
            );

            if (vehicle == null) {
                System.out.println("No available vehicle for " + task.getPackageId());
                continue;
            }

            Route route = routeService.getRoute(vehicle.getLocation(), task.getDestination());
            long eta = routeService.estimateEtaMinutes(route.getDistanceKm(), vehicle.getAvgSpeedKmph());

            task.setRoute(route);
            task.setEtaMinutes(eta);

            System.out.printf(
                "Assigned %s to Vehicle %s | Route: %s | ETA: %d min%n",
                task.getPackageId(), vehicle.getId(), route, eta
            );

            // Here you likely already submit to a thread pool; keep your existing executor code.
            // Example (pseudo):
            // executor.submit(() -> simulateDelivery(task, vehicle));
        }
    }
}
