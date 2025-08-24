package model;

public class Reservation {
    private String client;
    private String type; // Hotel, Auto, Vuelo
    private int quantity; // huéspedes, días o pasajeros
    private String extras; // descripción de extras

    public Reservation(String client, String type, int quantity, String extras) {
        this.client = client;
        this.type = type;
        this.quantity = quantity;
        this.extras = extras;
    }

    public void showDetails() {
        System.out.println("Reserva [" +
                "Cliente: " + client +
                ", Tipo: " + type +
                ", Cantidad: " + quantity +
                ", Extras: " + extras +
                "]");
    }
}