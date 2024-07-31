package DN3.ecommercePlatformSearch;

public class LinearSearch {

    public static Product linearSearch(Product[] p, String productName) {
        for (Product product : p) {
            // Compares the current product's name with the target name (case-insensitive)
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}
