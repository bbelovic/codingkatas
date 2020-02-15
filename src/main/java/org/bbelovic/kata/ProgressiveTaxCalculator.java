package org.bbelovic.kata;

import java.math.BigDecimal;
import java.util.Map;

public class ProgressiveTaxCalculator {
    private final Map<Long, BigDecimal> taxBrackets;

    public ProgressiveTaxCalculator(Map<Long, BigDecimal> taxBrackets) {
        this.taxBrackets = taxBrackets;
    }

    public BigDecimal calculate(BigDecimal income) {
        BigDecimal tax = BigDecimal.ZERO;
        long lowBound = 0L;
        for (var entry: taxBrackets.entrySet()) {
            var bracket = entry.getKey() - lowBound;
            if (income.compareTo(BigDecimal.valueOf(bracket)) > 0) {
                tax = tax.add(BigDecimal.valueOf(bracket).multiply(entry.getValue()));
            } else {
                tax = tax.add(income.multiply(entry.getValue()));
                break;
            }
            income = income.subtract(BigDecimal.valueOf(bracket));
            lowBound = entry.getKey();
        }
        return tax;
    }
}
