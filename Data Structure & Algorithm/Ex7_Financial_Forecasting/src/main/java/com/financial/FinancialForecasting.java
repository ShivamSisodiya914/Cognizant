package com.financial;

public class FinancialForecasting {
    public double forecastValue(double currentValue, double growthRate, int periods) {
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative");
        }
        if (periods == 0) {
            return currentValue;
        }
        return forecastValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public double forecastValueIterative(double currentValue, double growthRate, int periods) {
        double result = currentValue;
        for (int i = 0; i < periods; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }
}
