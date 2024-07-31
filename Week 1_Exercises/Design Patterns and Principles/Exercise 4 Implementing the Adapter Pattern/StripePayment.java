package DN3.AdapterPatternExample;

public class StripePayment {
	public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}
