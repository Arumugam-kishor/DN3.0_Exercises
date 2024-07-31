package DN3.DependancyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
	@Override
    public Customer findCustomerById(int id) {
        // For demonstration purposes, returning a dummy customer.
        // In a real application, this method would interact with a database.
        return new Customer(id, "abc", "abc.xyz@gmail.com");
    }
}
