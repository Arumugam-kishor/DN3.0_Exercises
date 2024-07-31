package DN3.CommandPattern;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Creating a receiver
		Light light = new Light();

		// Creating command objects
		Command lightOn = new LightOnCommand(light);
		Command lightOff = new LightOffCommand(light);

		// Creating an invoker
		RemoteControl remote = new RemoteControl();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Enter command (on/off/exit): ");
			String input = scanner.nextLine().trim().toLowerCase();

			switch (input) {
			case "on":
				remote.setCommand(lightOn);
				remote.pressButton();
				break;
			case "off":
				remote.setCommand(lightOff);
				remote.pressButton();
				break;
			case "exit":
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid command. Please enter 'on', 'off', or 'exit'.");
			}
		}
	}

}