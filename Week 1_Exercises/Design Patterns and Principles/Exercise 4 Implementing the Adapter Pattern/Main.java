package DN3.AdapterPatternExample;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter payment gateways to test, separated by commas (e.g., paypal,stripe):");
        String input = scanner.nextLine();

        List<String> gateways = Arrays.asList(input.split("\\s*,\\s*"));

        for (String gateway : gateways) {
            PaymentProcessor processor = PaymentProcessorFactory.getPaymentProcessor(gateway.trim());
            if (processor != null) {
                System.out.println("Testing with " + gateway + "...");
                processor.processPayment(100.00);
            } else {
                System.out.println("No processor found for " + gateway);
            }
        }

        scanner.close();
    }
}
