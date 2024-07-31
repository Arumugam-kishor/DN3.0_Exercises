package DN3.ecommercePlatformSearch;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {

    public static Product binarySearch(Product[] p, String productName) {
        // sorting the products array with product name
        Arrays.sort(p, Comparator.comparing(Product::getProductName));
        
        int left = 0;
        int right = p.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = p[mid].getProductName().compareToIgnoreCase(productName);
            
            if (comparison == 0) {
                return p[mid];
            } 
            
            else if (comparison < 0) {
                left = mid + 1;
            } 
            
            else {
                right = mid - 1;
            }
        }
        
        return null;
    }
}
