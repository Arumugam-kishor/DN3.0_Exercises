package DN3.StrategyPatternPrinciple;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        PaymentStrategy paymentStrategy = null;
        switch (choice) {
            case 1:
                System.out.print("Enter Credit Card number: ");
                String cardNumber = scanner.next();
                paymentStrategy = new CreditCardPayment(cardNumber);
                break;
            case 2:
                System.out.print("Enter PayPal email: ");
                String email = scanner.next();
                paymentStrategy = new PayPalPayment(email);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        System.out.print("Enter amount to pay: ");
        int amount = scanner.nextInt();

        PaymentContext context = new PaymentContext(paymentStrategy);
        context.executePayment(amount);

        scanner.close();
    }

}
