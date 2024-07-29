public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue; // Base case: no growth
        }
        // Recursive case: calculate future value by applying the growth rate
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate per year
        int years = 10; // Number of years to forecast

        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);
    }
}

