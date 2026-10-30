package cli;

import java.util.Scanner;
import service.VehicleService;
import service.TollService;

public class TollMenu {
    private Scanner scanner = new Scanner(System.in);
    private VehicleService vehicleService;
    private TollService tollService;

    public TollMenu(VehicleService vehicleService, TollService tollService) {
        this.vehicleService = vehicleService;
        this.tollService = tollService;
    }

    public void start() {
        while (true) {
            System.out.println("\n===== TOLL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. View Toll Plazas");
            System.out.println("4. View FASTag Accounts");
            System.out.println("5. Process Toll");
            System.out.println("6. Recharge FASTag");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Vehicle number: ");
                    String number = scanner.nextLine();
                    System.out.print("Owner name: ");
                    String owner = scanner.nextLine();
                    System.out.print("Vehicle type: ");
                    String type = scanner.nextLine();
                    vehicleService.addVehicle(number, owner, type);
                    break;

                case 2:
                    vehicleService.showVehicles();
                    break;

                case 3:
                    tollService.showPlazas();
                    break;

                case 4:
                    tollService.showFASTags();
                    break;

                case 5:
                    System.out.print("Vehicle number: ");
                    String vehicleNumber = scanner.nextLine();
                    System.out.print("Plaza ID: ");
                    String plazaId = scanner.nextLine();
                    tollService.processToll(vehicleNumber, plazaId);
                    break;

                case 6:
                    System.out.print("Vehicle number: ");
                    String rechargeVehicle = scanner.nextLine();
                    System.out.print("Recharge amount: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        tollService.recharge(rechargeVehicle, amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a valid amount.");
                    }
                    break;

                case 0:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
