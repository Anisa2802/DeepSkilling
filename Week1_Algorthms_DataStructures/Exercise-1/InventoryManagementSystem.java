import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    // Product class to represent individual products
    public static class Product {
        private String productId;
        private String productName;
        private int quantity;
        private double price;

        // Constructor
        public Product(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters and Setters
        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }
        
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
        }
    }

    // InventoryManager class to manage the inventory
    public static class InventoryManager {
        private Map<String, Product> inventory = new HashMap<>();

        // Add a product
        public void addProduct(Product product) {
            inventory.put(product.getProductId(), product);
        }

        // Update a product
        public void updateProduct(String productId, Product updatedProduct) {
            if (inventory.containsKey(productId)) {
                inventory.put(productId, updatedProduct);
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


        // List all products
        public void listAllProducts() {
            if (inventory.isEmpty()) {
                System.out.println("No products in inventory.");
                return;
            }
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of InventoryManager
        InventoryManager manager = new InventoryManager();

        // Create some products
        Product product1 = new Product("P001", "Laptop", 50, 999.99);
        Product product2 = new Product("P002", "Smartphone", 150, 499.99);
        Product product3 = new Product("P003", "Headphones", 200, 89.99);

        // Add products to the inventory
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        // List all products
        System.out.println("All Products:");
        manager.listAllProducts();

        // Update a product
        Product updatedProduct1 = new Product("P001", "Gaming Laptop", 30, 1299.99);
        manager.updateProduct("P001", updatedProduct1);

        // List all products after update
        System.out.println("\nAll Products After Update:");
        manager.listAllProducts();

        // Delete a product
        manager.deleteProduct("P002");

        // List all products after deletion
        System.out.println("\nAll Products After Deletion:");
        manager.listAllProducts();

        
    }
}
