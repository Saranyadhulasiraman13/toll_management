package service;

import models.Vehicle;
import repository.VehicleRepository;

public class VehicleService {
    private VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public void addVehicle(String number, String owner, String type) {
        if (repository.findVehicle(number) != null) {
            System.out.println("Vehicle already exists.");
            return;
        }

        Vehicle vehicle = new Vehicle(number, owner, type);
        repository.addVehicle(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    public void showVehicles() {
        repository.showVehicles();
    }
}
