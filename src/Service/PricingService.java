package Service;

public class PricingService {

    public double calculateHotel(int guests, boolean breakfast, boolean transport) {
        double base = guests * 50;
        if (breakfast) base += 10;
        if (transport) base += 15;
        return base;
    }

    public double calculateCar(int days, boolean gps, boolean insurance) {
        double base = days * 30;
        if (gps) base += 8;
        if (insurance) base += 12;
        return base;
    }

    public double calculateFlight(int passengers, boolean luggage, boolean priority) {
        double base = passengers * 100;
        if (luggage) base += 20;
        if (priority) base += 15;
        return base;
    }
}
