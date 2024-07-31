package DN3.InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update an existing product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display all products
    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}
