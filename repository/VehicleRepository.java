package repository;

import java.util.ArrayList;
import models.Vehicle;

public class VehicleRepository {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle findVehicle(String number) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNumber().equalsIgnoreCase(number)) {
                return vehicle;
            }
        }
        return null;
    }

    public void showVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
        }
    }
}
