package DN3.AdapterPatternExample;

public class StripeAdapter implements PaymentProcessor {
	private StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment(double amount) {
        stripePayment.pay(amount);
    }
}
