package Strategy;

public class PayPalPayment implements PaymentMethodInterface {
    @Override
    public void pay(double amount) {
        System.out.println("Pago de $" + amount + " con PayPal.");
    }
}
