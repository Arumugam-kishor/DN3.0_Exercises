package DN3.DecoratorPatternExample;

public class EmailNotifier implements Notifier {
	 @Override
	    public void send(String message) {
	        System.out.println("Sending email with message: " + message);
	    }
}
