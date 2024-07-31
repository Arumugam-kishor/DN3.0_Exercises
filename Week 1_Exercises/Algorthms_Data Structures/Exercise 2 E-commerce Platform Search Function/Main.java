package DN3.ecommercePlatformSearch;

public class Main {

    public static void main(String[] args) {
        // Creating an array of products
        Product[] p = {
            new Product(1, "Shirt", "Clothing"),
            new Product(2, "Shoes", "Footwear"),
     		new Product(3, "Coolers", "Accessories"),
            new Product(4, "Watch", "Electronics")

        };

        // Performing a linear search for "Shirt"
        Product foundProduct = LinearSearch.linearSearch(p, "Shirt");
        System.out.println("Linear Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));

        // Performing a binary search for "Shoes"
        foundProduct = BinarySearch.binarySearch(p, "Shoes");
        System.out.println("Binary Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));
    }
}
