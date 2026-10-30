package service;

import models.FASTag;
import models.TollPlaza;
import repository.TollRepository;

public class TollService {
    private TollRepository repository;

    public TollService(TollRepository repository) {
        this.repository = repository;
    }

    public void showPlazas() {
        repository.showPlazas();
    }

    public void showFASTags() {
        repository.showFASTags();
    }

    public void recharge(String vehicleNumber, double amount) {
        FASTag tag = repository.findFASTag(vehicleNumber);

        if (tag == null) {
            System.out.println("FASTag not found.");
            return;
        }

        tag.recharge(amount);
    }

    public void processToll(String vehicleNumber, String plazaId) {
        FASTag tag = repository.findFASTag(vehicleNumber);
        TollPlaza plaza = repository.findPlaza(plazaId);

        if (tag == null) {
            System.out.println("FASTag not found. Please use Cash lane.");
            return;
        }

        if (plaza == null) {
            System.out.println("Toll plaza not found.");
            return;
        }

        if (tag.deductAmount(plaza.getTollAmount())) {
            System.out.println("Toll paid successfully.");
            System.out.println("Amount: Rs." + plaza.getTollAmount());
            System.out.println("Barrier opened.");
            System.out.println("Remaining balance: Rs." + tag.getBalance());
        } else {
            System.out.println("Insufficient FASTag balance. Please use Cash lane.");
        }
    }
}
