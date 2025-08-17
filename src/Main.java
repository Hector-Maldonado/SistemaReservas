import system.BookingSystem;  // Singleton: sistema centralizado de reservas
import factory.*;              // Factory Method: crear reservas básicas
import builder.*;              // Builders especializados: crear reservas complejas con extras
import model.Reservation;      // Clase base de reservas

public class Main {
    public static void main(String[] args) {


        // 1 Singleton
        // Obtenemos la instancia única del sistema de reservas
        BookingSystem system = BookingSystem.getInstance();


        // 2 Factory Method (reservas básicas)
        // Creamos una reserva de hotel básica sin extras
        ReservationFactory hotelFactory = new HotelReservationFactory();
        Reservation basicHotel = hotelFactory.createReservation("Héctor", 2);
        system.addReservation(basicHotel); // Agregamos al sistema

        // Creamos una reserva de auto básica sin extras
        ReservationFactory carFactory = new CarReservationFactory();
        Reservation basicCar = carFactory.createReservation("Omar", 3);
        system.addReservation(basicCar);

        // Creamos una reserva de vuelo básica sin extras
        ReservationFactory flightFactory = new FlightReservationFactory();
        Reservation basicFlight = flightFactory.createReservation("Ana", 1);
        system.addReservation(basicFlight);


        // 3 Builder (reservas con extras)
        // Builder para Hotel: agregamos desayuno y transporte
        Reservation hotelWithExtras = new HotelReservationBuilder()
                .setClient("Héctor")       // Nombre del cliente
                .setGuests(2)              // Número de huéspedes
                .includeBreakfast(true)    // Agregar desayuno
                .includeTransport(true)    // Agregar transporte
                .build();                  // Construir objeto Reservation
        system.addReservation(hotelWithExtras);

        // Builder para Auto: agregamos GPS y seguro
        Reservation carWithExtras = new CarReservationBuilder()
                .setClient("Omar")         // Nombre del cliente
                .setDays(5)                // Cantidad de días
                .includeGPS(true)          // Agregar GPS
                .includeInsurance(true)    // Agregar seguro
                .build();                  // Construir objeto Reservation
        system.addReservation(carWithExtras);

        // Builder para Vuelo: agregamos equipaje extra y embarque prioritario
        Reservation flightWithExtras = new FlightReservationBuilder()
                .setClient("Ana")          // Nombre del cliente
                .setPassengers(2)          // Número de pasajeros
                .includeExtraLuggage(true) // Agregar equipaje extra
                .includePriorityBoarding(true) // Embarque prioritario
                .build();                  // Construir objeto Reservation
        system.addReservation(flightWithExtras);

        // 4 Mostrar todas las reservas
        // Imprime todas las reservas del sistema, sean creadas por Factory o Builder
        system.showAllReservations();


    }
}