public class FinancialForecasting {

    /**
     * Recursive method to calculate future value.
     * Formula: FV = PV * (1 + growthRate)^years
     * * @param currentValue The initial value
     * @param growthRate The constant growth rate (e.g., 0.05 for 5%)
     * @param periods The number of periods (years) into the future
     * @return The predicted future value
     */
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base Case: If there are no more periods, the value stops growing.
        if (periods == 0) {
            return currentValue;
        }

        // Recursive Step: The value for the next period is the current value + growth.
        // We then call the method again for the remaining periods.
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Starting amount
        double annualGrowthRate = 0.05; // 5% growth
        int yearsToForecast = 10;

        double predictedValue = calculateFutureValue(presentValue, annualGrowthRate, yearsToForecast);

        System.out.printf("Present Value: $%.2f\n", presentValue);
        System.out.printf("Growth Rate: %.0f%%\n", (annualGrowthRate * 100));
        System.out.printf("Forecast Period: %d years\n", yearsToForecast);
        System.out.printf("Predicted Future Value: $%.2f\n", predictedValue);
        
        /*
         * Analysis (For your understanding/comments):
         * The time complexity of this recursive algorithm is O(n), where n is the number of periods,
         * because it makes exactly one recursive call per period.
         * * Optimization note: While simple, this recursive approach can lead to a StackOverflowError 
         * for very large values of 'periods'. It can be optimized using an iterative loop (O(n) time, O(1) space)
         * or by simply using the mathematical formula Math.pow(1 + rate, periods) which is O(1) time.
         */
    }
}