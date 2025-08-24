package Strategy;

public class CashMethod implements PaymentMethodInterface {
    @Override
    public void pay(double amount) {
        System.out.println("Pago de $" + amount + " en EFECTIVO.");
    }
}