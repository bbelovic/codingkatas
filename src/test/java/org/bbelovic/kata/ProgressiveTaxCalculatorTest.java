package org.bbelovic.kata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

public class ProgressiveTaxCalculatorTest {
    @Test
    public void shouldComputeProgressiveTaxFromGivenSalary() {
        Map.of(10_000, BigDecimal.ONE.add(BigDecimal.TEN).divide(BigDecimal.TEN));
        Map.of(10_000, new BigDecimal("0.11"), 38_000, new BigDecimal("0.20"));
        ProgressiveTaxCalculator calculator = new ProgressiveTaxCalculator();
    }
}
