package builder;

import model.Reservation;

public class HotelReservationBuilder {
    private String client;
    private int guests;
    private boolean breakfastIncluded;
    private boolean transportIncluded;

    public HotelReservationBuilder setClient(String client) { this.client = client; return this; }
    public HotelReservationBuilder setGuests(int guests) { this.guests = guests; return this; }
    public HotelReservationBuilder includeBreakfast(boolean breakfast) { this.breakfastIncluded = breakfast; return this; }
    public HotelReservationBuilder includeTransport(boolean transport) { this.transportIncluded = transport; return this; }

    public Reservation build() {
        String extras = "";
        if (breakfastIncluded) extras += "Desayuno ";
        if (transportIncluded) extras += "Transporte ";
        return new Reservation(client, "Hotel", guests, extras.trim());
    }
}