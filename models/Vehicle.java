package models;

public class Vehicle {
    private String number;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String number, String ownerName, String vehicleType) {
        this.number = number;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getNumber() { return number; }
    public String getOwnerName() { return ownerName; }
    public String getVehicleType() { return vehicleType; }

    public void display() {
        System.out.println(number + " | " + ownerName + " | " + vehicleType);
    }
}
