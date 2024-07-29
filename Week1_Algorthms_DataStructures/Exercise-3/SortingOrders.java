import java.util.Arrays;

public class SortingOrders {

    // Order class to represent individual orders
    public static class Order {
        private String orderId;
        private String customerName;
        private double totalPrice;

        // Constructor
        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        // Getters
        public String getOrderId() { return orderId; }
        public String getCustomerName() { return customerName; }
        public double getTotalPrice() { return totalPrice; }

        // Override toString for better representation
        @Override
        public String toString() {
            return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
        }
    }

    // Bubble Sort implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    
    // Quick Sort implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high]
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Main method to demonstrate sorting functionality
    public static void main(String[] args) {
        // Create sample orders
        Order[] orders = {
            new Order("O003", "Alice", 300.50),
            new Order("O001", "Bob", 150.75),
            new Order("O002", "Charlie", 250.00)
        };

        // Perform Bubble Sort
        Order[] ordersForBubbleSort = orders.clone();
        bubbleSort(ordersForBubbleSort);
        System.out.println("Orders sorted by Bubble Sort:");
        for (Order order : ordersForBubbleSort) {
            System.out.println(order);
        }

        // Perform Quick Sort
        Order[] ordersForQuickSort = orders.clone();
        quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        for (Order order : ordersForQuickSort) {
            System.out.println(order);
        }
    }
}
