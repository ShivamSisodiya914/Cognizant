package com.financial;

public class FinancialForecastingTest {
    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();

        double recursiveResult = forecasting.forecastValue(1000, 0.1, 3);
        double iterativeResult = forecasting.forecastValueIterative(1000, 0.1, 3);

        assertApproxEqual(recursiveResult, 1331.0, 0.0001, "Recursive forecast should grow correctly");
        assertApproxEqual(iterativeResult, 1331.0, 0.0001, "Iterative forecast should grow correctly");

        System.out.println("All financial forecasting tests passed.");
    }

    private static void assertApproxEqual(double actual, double expected, double tolerance, String message) {
        if (Math.abs(actual - expected) > tolerance) {
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }
}
