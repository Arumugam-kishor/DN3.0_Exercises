package DN3.DependancyInjectionExample;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		CustomerRepository customerRepository = new CustomerRepositoryImpl();

		CustomerService customerService = new CustomerService(customerRepository);

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter customer ID to search: ");
		int customerId = scanner.nextInt();

		Customer customer = customerService.getCustomerById(customerId);

		if (customer != null) {
			System.out.println("Customer ID: " + customer.getId());
			System.out.println("Customer Name: " + customer.getName());
			System.out.println("Customer Email: " + customer.getEmail());
		} else {
			System.out.println("Customer not found.");
		}

		scanner.close();
	}

}
