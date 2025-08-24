package factory;

import model.Reservation;

// Clase abstracta
public abstract class ReservationFactory {
    public abstract Reservation createReservation(String client, int quantity);
}