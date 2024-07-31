import DN3.InventoryManagementSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean b = true;

        while (b) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Product
                    System.out.print("Enter Product ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Product Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Product Price: ");
                    double addPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over
                    ims.addProduct(new Product(addId, addName, addQuantity, addPrice));
                    System.out.println("Product added successfully.");
                    break;

                case 2: // Update Product
                    System.out.print("Enter Product ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new Product Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new Product Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter new Product Price: ");
                    double updatePrice = scanner.nextDouble();
                    ims.updateProduct(new Product(updateId, updateName, updateQuantity, updatePrice));
                    System.out.println("Product updated successfully.");
                    break;

                case 3: // Delete Product
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ims.deleteProduct(deleteId);
                    System.out.println("Product deleted successfully.");
                    break;

                case 4: // Display Products
                    ims.displayProducts();
                    break;

                case 5: // Exit
                    b = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}
