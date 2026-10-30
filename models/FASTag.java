package models;

public class FASTag {
    private String tagId;
    private String vehicleNumber;
    private double balance;

    public FASTag(String tagId, String vehicleNumber, double balance) {
        this.tagId = tagId;
        this.vehicleNumber = vehicleNumber;
        this.balance = balance;
    }

    public String getTagId() { return tagId; }
    public String getVehicleNumber() { return vehicleNumber; }
    public double getBalance() { return balance; }

    public boolean deductAmount(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public void recharge(double amount) {
        if (amount >= 100 && amount <= 10000 && balance + amount <= 50000) {
            balance = balance + amount;
            System.out.println("Recharge successful. Balance: Rs." + balance);
        } else {
            System.out.println("Invalid recharge amount or maximum balance exceeded.");
        }
    }

    public void display() {
        System.out.println(tagId + " | " + vehicleNumber + " | Rs." + balance);
    }
}
