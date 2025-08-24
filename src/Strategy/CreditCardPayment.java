package Strategy;

public class CreditCardPayment implements PaymentMethodInterface {
    @Override
    public void pay(double amount) {
        System.out.println("Pago de $" + amount + " con Tarjeta de Crédito.");
    }
}
