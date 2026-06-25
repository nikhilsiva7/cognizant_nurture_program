import java.util.Arrays;

public class EcommerceSearch {

    // Linear Search Implementation (O(n) Time Complexity)
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product; // Found the product
            }
        }
        return null; // Product not found
    }

    // Binary Search Implementation (O(log n) Time Complexity)
    // IMPORTANT: The array must be sorted by productId before calling this method.
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == targetId) {
                return products[mid]; // Found the product
            }

            // If target is greater, ignore the left half
            if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } 
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        // Create an array of Products
        Product[] inventory = {
            new Product(104, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(105, "Coffee Mug", "Home"),
            new Product(102, "Desk Lamp", "Home"),
            new Product(103, "Ergonomic Chair", "Furniture")
        };

        System.out.println("--- Testing Linear Search ---");
        Product foundLinear = linearSearch(inventory, 102);
        System.out.println("Search for ID 102: " + (foundLinear != null ? foundLinear : "Not Found"));

        System.out.println("\n--- Testing Binary Search ---");
        // Binary search requires a sorted array
        Arrays.sort(inventory); 
        System.out.println("Inventory sorted by Product ID.");
        
        Product foundBinary = binarySearch(inventory, 105);
        System.out.println("Search for ID 105: " + (foundBinary != null ? foundBinary : "Not Found"));
        
        /* * Analysis (For your understanding/comments):
         * Linear Search checks every element, so its worst-case time complexity is O(n).
         * Binary Search splits the array in half each time, giving a much faster worst-case of O(log n).
         * Binary search is more suitable for large, relatively static datasets where we search frequently.
         * Linear search is suitable for small or constantly changing datasets where sorting overhead is high.
         */
    }
}