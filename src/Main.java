import  system.*;
import builder.CarReservationBuilder;
import builder.FlightReservationBuilder;
import builder.HotelReservationBuilder;
import model.Reservation;
import Service.PricingService;
import Strategy.CashMethod;
import Strategy.CreditCardPayment;
import Strategy.PayPalPayment;
import Strategy.PaymentMethodInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookingSystem system = BookingSystem.getInstance();
        PricingService pricing = new PricingService();
        Scanner scanner = new Scanner(System.in);

        Reservation r1 = new HotelReservationBuilder()
                .setClient("Alice")
                .setGuests(2)
                .includeBreakfast(true)
                .includeTransport(false)
                .build();
        system.addReservation(r1);

        Reservation r2 = new CarReservationBuilder()
                .setClient("Bob")
                .setDays(5)
                .includeGPS(true)
                .includeInsurance(true)
                .build();
        system.addReservation(r2);

        Reservation r3 = new FlightReservationBuilder()
                .setClient("Charlie")
                .setPassengers(3)
                .includeExtraLuggage(true)
                .includePriorityBoarding(false)
                .build();
        system.addReservation(r3);

        boolean running = true;
        while (running) {
            System.out.println("\n=== MENÚ DEL SISTEMA DE RESERVAS ===");
            System.out.println("1. Nueva reserva");
            System.out.println("2. Mostrar todas las reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> crearReserva(scanner, system, pricing);
                case 2 -> system.showAllReservations();
                case 0 -> running = false;
                default -> System.out.println("Opción inválida");
            }
        }
        scanner.close();
    }

    private static void crearReserva(Scanner scanner, BookingSystem system, PricingService pricing) {
        System.out.println("\nTipo de reserva:");
        System.out.println("1. Hotel");
        System.out.println("2. Auto");
        System.out.println("3. Vuelo");
        System.out.print("Opción: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre del cliente: ");
        String client = scanner.nextLine().trim();

        Reservation nueva;
        double monto = 0.0;

        switch (tipo) {
            case 1 -> {
                System.out.print("Número de huéspedes: ");
                int guests = Integer.parseInt(scanner.nextLine());
                boolean breakfast = askYesNo(scanner, "¿Desayuno incluido? (s/n): ");
                boolean transport = askYesNo(scanner, "¿Transporte incluido? (s/n): ");

                nueva = new HotelReservationBuilder()
                        .setClient(client)
                        .setGuests(guests)
                        .includeBreakfast(breakfast)
                        .includeTransport(transport)
                        .build();

                monto = pricing.calculateHotel(guests, breakfast, transport);
            }
            case 2 -> {
                System.out.print("Número de días: ");
                int days = Integer.parseInt(scanner.nextLine());
                boolean gps = askYesNo(scanner, "¿GPS incluido? (s/n): ");
                boolean insurance = askYesNo(scanner, "¿Seguro incluido? (s/n): ");

                nueva = new CarReservationBuilder()
                        .setClient(client)
                        .setDays(days)
                        .includeGPS(gps)
                        .includeInsurance(insurance)
                        .build();

                monto = pricing.calculateCar(days, gps, insurance);
            }
            case 3 -> {
                System.out.print("Número de pasajeros: ");
                int passengers = Integer.parseInt(scanner.nextLine());
                boolean luggage = askYesNo(scanner, "¿Equipaje extra? (s/n): ");
                boolean priority = askYesNo(scanner, "¿Embarque prioritario? (s/n): ");

                nueva = new FlightReservationBuilder()
                        .setClient(client)
                        .setPassengers(passengers)
                        .includeExtraLuggage(luggage)
                        .includePriorityBoarding(priority)
                        .build();

                monto = pricing.calculateFlight(passengers, luggage, priority);
            }
            default -> {
                System.out.println("Tipo inválido. Cancelando reserva.");
                return;
            }
        }

        PaymentMethodInterface payment = choosePayment(scanner);
        System.out.printf("Monto a pagar: $%.2f%n", monto);

        if (!askYesNo(scanner, "¿Confirmar y registrar la reserva? (s/n): ")) {
            System.out.println("Reserva cancelada.");
            return;
        }

        system.addReservation(nueva);
        payment.pay(monto);
        System.out.println("Reserva registrada con éxito.");
    }

    private static boolean askYesNo(Scanner scanner, String msg) {
        System.out.print(msg);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("s") || input.equals("si");
    }

    private static PaymentMethodInterface choosePayment(Scanner scanner) {
        System.out.println("\nMétodo de pago:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. PayPal");
        System.out.println("3. Efectivo");
        System.out.print("Opción: ");
        int payOpt = Integer.parseInt(scanner.nextLine());

        return switch (payOpt) {
            case 1 -> new CreditCardPayment();
            case 2 -> new PayPalPayment();
            default -> new CashMethod();
        };
    }
}
