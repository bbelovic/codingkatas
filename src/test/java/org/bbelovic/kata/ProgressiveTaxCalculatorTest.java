package org.bbelovic.kata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressiveTaxCalculatorTest {
    @Test
    public void shouldComputeProgressiveTaxFromGivenSalary() {
        Map<Long, BigDecimal> m = new LinkedHashMap<>();
        m.put(10_000L, new BigDecimal("0.11"));
        m.put(38_000L, new BigDecimal("0.20"));
        ProgressiveTaxCalculator calculator = new ProgressiveTaxCalculator(m);
        var income = new BigDecimal("12500");
        var actual = calculator.calculate(income);
        assertThat(actual).
                isEqualTo(new BigDecimal("1600.00"));
    }
}
