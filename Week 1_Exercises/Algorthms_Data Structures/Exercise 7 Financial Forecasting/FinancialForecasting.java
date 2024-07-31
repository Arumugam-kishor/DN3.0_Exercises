package DN3.FinancialForecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    private static Map<Integer, Double> memo = new HashMap<>();

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }

        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }

        double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);

        memo.put(periods, futureValue);

        return futureValue;
    }
}