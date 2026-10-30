import models.Vehicle;
import models.TollPlaza;
import models.FASTag;
import repository.VehicleRepository;
import repository.TollRepository;
import service.VehicleService;
import service.TollService;
import cli.TollMenu;

public class Main {
    public static void main(String[] args) {
        // Create repositories
        VehicleRepository vehicleRepository = new VehicleRepository();
        TollRepository tollRepository = new TollRepository();

        // Add sample vehicles
        Vehicle car = new Vehicle("TN38AB1234", "Arun", "Car");
        Vehicle bus = new Vehicle("TN37CD5678", "Kumar", "Bus");
        vehicleRepository.addVehicle(car);
        vehicleRepository.addVehicle(bus);

        // Add sample FASTag accounts
        tollRepository.addFASTag(new FASTag("TAG101", "TN38AB1234", 500));
        tollRepository.addFASTag(new FASTag("TAG102", "TN37CD5678", 80));

        // Add sample toll plaza
        tollRepository.addPlaza(new TollPlaza("P1", "Avinashi Toll Plaza", 100));

        // Create services and menu
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        TollService tollService = new TollService(tollRepository);
        TollMenu menu = new TollMenu(vehicleService, tollService);

        menu.start();
    }
}
