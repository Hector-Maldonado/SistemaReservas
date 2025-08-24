package factory;

import model.Reservation;

// Factory concreto para Hotel
public class HotelReservationFactory extends ReservationFactory {
    @Override
    public Reservation createReservation(String client, int guests) {
        return new Reservation(client, "Hotel", guests, "Sin extras");
    }
}