package factory;

import model.Reservation;

// Factory concreto para Auto
public class CarReservationFactory extends ReservationFactory {
    @Override
    public Reservation createReservation(String client, int days) {
        return new Reservation(client, "Auto", days, "Sin extras");
    }
}