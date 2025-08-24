package builder;

public class ReservationBuilder {
    private String client;
    private String service;
    private int guests;

    // Extras generales
    private boolean breakfastIncluded;
    private boolean transportIncluded;

    // Extras de vuelo
    private boolean extraLuggage;
    private boolean priorityBoarding;

    // Extras de auto
    private boolean gpsIncluded;
    private boolean insuranceIncluded;

    // Constructor privado
    private ReservationBuilder(ReservationBuilders builder) {
        this.client = builder.client;
        this.service = builder.service;
        this.guests = builder.guests;
        this.breakfastIncluded = builder.breakfastIncluded;
        this.transportIncluded = builder.transportIncluded;
        this.extraLuggage = builder.extraLuggage;
        this.priorityBoarding = builder.priorityBoarding;
        this.gpsIncluded = builder.gpsIncluded;
        this.insuranceIncluded = builder.insuranceIncluded;
    }

    // Mostrar detalles de la reserva
    public void showDetails() {
        System.out.println("\n Reserva creada con Builder");
        System.out.println("Servicio: " + service);
        System.out.println("Cliente: " + client);
        System.out.println("Huéspedes/Pasajeros: " + guests);

        // Opciones específicas
        if (service.equalsIgnoreCase("Hotel")) {
            if (breakfastIncluded) System.out.println("- Desayuno incluido");
            if (transportIncluded) System.out.println("- Transporte incluido");
        }
        if (service.equalsIgnoreCase("Vuelo")) {
            if (extraLuggage) System.out.println("- Equipaje extra incluido");
            if (priorityBoarding) System.out.println("- Embarque prioritario");
        }
        if (service.equalsIgnoreCase("Auto")) {
            if (gpsIncluded) System.out.println("- GPS incluido");
            if (insuranceIncluded) System.out.println("- Seguro incluido");
        }
    }

    //Clase Builder Interna
    public static class ReservationBuilders {
        private String client;
        private String service;
        private int guests;

        private boolean breakfastIncluded;
        private boolean transportIncluded;

        private boolean extraLuggage;
        private boolean priorityBoarding;

        private boolean gpsIncluded;
        private boolean insuranceIncluded;

        public ReservationBuilders setClient(String client) {
            this.client = client;
            return this;
        }

        public ReservationBuilders setService(String service) {
            this.service = service;
            return this;
        }

        public ReservationBuilders setGuests(int guests) {
            this.guests = guests;
            return this;
        }

        // Opciones para Hotel
        public ReservationBuilders includeBreakfast(boolean breakfast) {
            this.breakfastIncluded = breakfast;
            return this;
        }

        public ReservationBuilders includeTransport(boolean transport) {
            this.transportIncluded = transport;
            return this;
        }

        // Opciones para Vuelo
        public ReservationBuilders includeExtraLuggage(boolean luggage) {
            this.extraLuggage = luggage;
            return this;
        }

        public ReservationBuilders includePriorityBoarding(boolean priority) {
            this.priorityBoarding = priority;
            return this;
        }

        // Opciones para Auto
        public ReservationBuilders includeGPS(boolean gps) {
            this.gpsIncluded = gps;
            return this;
        }

        public ReservationBuilders includeInsurance(boolean insurance) {
            this.insuranceIncluded = insurance;
            return this;
        }

        public ReservationBuilder build() {
            return new ReservationBuilder(this);
        }
    }
}