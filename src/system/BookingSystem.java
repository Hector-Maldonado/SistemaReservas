package system;

import model.Reservation;
import java.util.ArrayList;
import java.util.List;

// Singleton: Asegura que solo exista una instancia del sistema de reservas
public class BookingSystem {
    private static BookingSystem instance;   // Instancia única
    private List<Reservation> reservations;  // Lista donde se guardan todas las reservas

    // Constructor privado: nadie más puede crear instancias
    private BookingSystem() {
        reservations = new ArrayList<>();
    }

    // Método público para obtener la instancia única
    public static BookingSystem getInstance() {
        if (instance == null) {
            instance = new BookingSystem();
        }
        return instance;
    }

    // Agregar una reserva a la lista
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Mostrar todas las reservas registradas
    public void showAllReservations() {
        System.out.println("\n TODAS LAS RESERVAS ");
        for (Reservation r : reservations) {
            r.showDetails();
        }
    }
}