package repository;

import java.util.ArrayList;
import models.TollPlaza;
import models.FASTag;

public class TollRepository {
    private ArrayList<TollPlaza> plazas = new ArrayList<>();
    private ArrayList<FASTag> tags = new ArrayList<>();

    public void addPlaza(TollPlaza plaza) {
        plazas.add(plaza);
    }

    public void addFASTag(FASTag tag) {
        tags.add(tag);
    }

    public TollPlaza findPlaza(String plazaId) {
        for (TollPlaza plaza : plazas) {
            if (plaza.getPlazaId().equalsIgnoreCase(plazaId)) {
                return plaza;
            }
        }
        return null;
    }

    public FASTag findFASTag(String vehicleNumber) {
        for (FASTag tag : tags) {
            if (tag.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                return tag;
            }
        }
        return null;
    }

    public void showPlazas() {
        for (TollPlaza plaza : plazas) {
            plaza.display();
        }
    }

    public void showFASTags() {
        for (FASTag tag : tags) {
            tag.display();
        }
    }
}
