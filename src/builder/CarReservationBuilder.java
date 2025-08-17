package builder;

import model.Reservation;

public class CarReservationBuilder {
    private String client;
    private int days;
    private boolean gpsIncluded;
    private boolean insuranceIncluded;

    public CarReservationBuilder setClient(String client) { this.client = client; return this; }
    public CarReservationBuilder setDays(int days) { this.days = days; return this; }
    public CarReservationBuilder includeGPS(boolean gps) { this.gpsIncluded = gps; return this; }
    public CarReservationBuilder includeInsurance(boolean insurance) { this.insuranceIncluded = insurance; return this; }

    public Reservation build() {
        String extras = "";
        if (gpsIncluded) extras += "GPS ";
        if (insuranceIncluded) extras += "Seguro ";
        return new Reservation(client, "Auto", days, extras.trim());
    }
}
