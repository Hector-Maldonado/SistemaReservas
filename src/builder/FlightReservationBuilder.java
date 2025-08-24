package builder;

import model.Reservation;

public class FlightReservationBuilder {
    private String client;
    private int passengers;
    private boolean extraLuggage;
    private boolean priorityBoarding;

    public FlightReservationBuilder setClient(String client) { this.client = client; return this; }
    public FlightReservationBuilder setPassengers(int passengers) { this.passengers = passengers; return this; }
    public FlightReservationBuilder includeExtraLuggage(boolean luggage) { this.extraLuggage = luggage; return this; }
    public FlightReservationBuilder includePriorityBoarding(boolean boarding) { this.priorityBoarding = boarding; return this; }

    public Reservation build() {
        String extras = "";
        if (extraLuggage) extras += "Equipaje extra ";
        if (priorityBoarding) extras += "Embarque prioritario ";
        return new Reservation(client, "Vuelo", passengers, extras.trim());
    }
}