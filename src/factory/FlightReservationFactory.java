package factory;

import model.Reservation;

// Factory concreto para Vuelo
public class FlightReservationFactory extends ReservationFactory {
    @Override
    public Reservation createReservation(String client, int passengers) {
        return new Reservation(client, "Vuelo", passengers, "Sin extras");
    }
}