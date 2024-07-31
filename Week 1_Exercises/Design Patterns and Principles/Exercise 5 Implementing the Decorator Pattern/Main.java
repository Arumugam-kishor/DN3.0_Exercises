package DN3.DecoratorPatternExample;
import java.util.*;
public class Main {
	public static void main(String[] args) {
        Notifier baseNotifier = new EmailNotifier();
        
        List<NotifierDecorator> decorators = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Which decorators would you like to add? (Type 'SMS', 'Slack', or 'None')");
        String input;
        
        while (!(input = scanner.nextLine()).equalsIgnoreCase("None")) {
            switch (input.trim().toLowerCase()) {
                case "sms":
                    decorators.add(new SMSNotifierDecorator(baseNotifier));
                    baseNotifier = decorators.get(decorators.size() - 1);
                    break;
                case "slack":
                    decorators.add(new SlackNotifierDecorator(baseNotifier));
                    baseNotifier = decorators.get(decorators.size() - 1);
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'SMS', 'Slack', or 'None'.");
            }
            
            System.out.println("Add another decorator or type 'None' to finish:");
        }
        
        System.out.println("Sending a message with all selected decorators...");
        baseNotifier.send("Hello, this is a dynamic test message.");
        
        scanner.close();
    }
}
