import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {

    // Product class to represent individual products
    public static class Product {
        private String productId;
        private String productName;
        private String category;

        // Constructor
        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        // Getters
        public String getProductId() { return productId; }
        public String getProductName() { return productName; }
        public String getCategory() { return category; }

        // Override toString for better representation
        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    // Search algorithms class
    public static class SearchAlgorithms {

        // Linear search implementation
        public static Product linearSearch(Product[] products, String searchTerm) {
            for (Product product : products) {
                if (product.getProductId().equals(searchTerm) ||
                    product.getProductName().equals(searchTerm) ||
                    product.getCategory().equals(searchTerm)) {
                    return product;
                }
            }
            return null; // Product not found
        }

        // Binary search implementation
        public static Product binarySearch(Product[] products, String searchTerm) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                Product midProduct = products[mid];

                if (midProduct.getProductId().equals(searchTerm)) {
                    return midProduct;
                } else if (midProduct.getProductId().compareTo(searchTerm) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null; // Product not found
        }

        // Helper method to sort products by productId
        public static void sortProductsById(Product[] products) {
            Arrays.sort(products, Comparator.comparing(Product::getProductId));
        }
    }

    // Main method to demonstrate search functionality
    public static void main(String[] args) {
        // Create sample products
        Product[] products = {
            new Product("P003", "Headphones", "Electronics"),
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics")
        };

        // Perform linear search
        String searchTerm = "P002";
        Product resultLinear = SearchAlgorithms.linearSearch(products, searchTerm);
        System.out.println("Linear Search Result:");
        System.out.println(resultLinear != null ? resultLinear : "Product not found");

        // Sort products for binary search
        SearchAlgorithms.sortProductsById(products);

        // Perform binary search
        Product resultBinary = SearchAlgorithms.binarySearch(products, searchTerm);
        System.out.println("\nBinary Search Result:");
        System.out.println(resultBinary != null ? resultBinary : "Product not found");
    }
}
