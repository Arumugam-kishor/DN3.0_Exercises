package DN3.FinancialForecasting;

public class Main {
    public static void main(String[] args) {
        // Example usage
        double presentValue = 1000.0; // Present value
        double growthRate = 0.05; // Growth rate (e.g., 5%)
        int periods = 10; // Number of periods (e.g., years)
        double futureValue = FinancialForecasting.calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("The future value after %d periods is: %.2f%n", periods, futureValue);
    }
}
