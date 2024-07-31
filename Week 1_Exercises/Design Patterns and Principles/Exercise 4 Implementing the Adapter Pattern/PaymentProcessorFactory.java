package DN3.AdapterPatternExample;

public class PaymentProcessorFactory {
	public static PaymentProcessor getPaymentProcessor(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "paypal":
                return new PayPalAdapter(new PayPalPayment());
            case "stripe":
                return new StripeAdapter(new StripePayment());
            default:
                throw new IllegalArgumentException("Unknown payment gateway type: " + gatewayType);
        }
    }
}
