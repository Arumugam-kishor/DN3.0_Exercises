package DN3.SortingCustomerOrders;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Order[] order = new Order[5];
		order[0] = new Order(1, "abc", 250.75);
		order[1] = new Order(2, "def", 300.50);
		order[2] = new Order(3, "ghi", 150.20);
		order[3] = new Order(4,"jkl",145.262);
		order[4] = new Order(5,"mno",475.12);

		System.out.println("Before Sorting:");
		for (Order orders : order) {
			if (orders != null) {
				System.out.println("Order ID: " + orders.getOrderId());
				System.out.println("Customer Name: " + orders.getCustomerName());
				System.out.println("Total Price: " + orders.getTotalPrice());
				System.out.println();
			}
		}

		System.out.println("After Bubble Sorting:");
		Order.bubbleSort(order);
		System.out.println("\nAfter sorting:");
		for (Order orders : order) {
			if (orders != null) {
				System.out.println("Order ID: " + orders.getOrderId() + ", Customer Name: " + orders.getCustomerName()+ ", Total Price: " + orders.getTotalPrice());
			}
		}
	
		System.out.println("After Quick Sorting");
		order = Arrays.stream(order).filter(o -> o != null).toArray(Order[]::new);

		Order.quickSort(order,0,order.length-1);
		for (Order orders : order) {
            if (orders != null) {
                System.out.println("Order ID: " + orders.getOrderId() + ", Customer Name: " + orders.getCustomerName() +", Total Price: " + orders.getTotalPrice());
            }
        }

	}
}
