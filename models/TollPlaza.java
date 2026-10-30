package models;

public class TollPlaza {
    private String plazaId;
    private String plazaName;
    private double tollAmount;

    public TollPlaza(String plazaId, String plazaName, double tollAmount) {
        this.plazaId = plazaId;
        this.plazaName = plazaName;
        this.tollAmount = tollAmount;
    }

    public String getPlazaId() { return plazaId; }
    public String getPlazaName() { return plazaName; }
    public double getTollAmount() { return tollAmount; }

    public void display() {
        System.out.println(plazaId + " | " + plazaName + " | Rs." + tollAmount);
    }
}
