package org.bbelovic.kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressiveTaxCalculatorTest {
    private static Object[][] testData() {
        return new Object[][] {
                {new BigDecimal("9700"), new BigDecimal("1067.00")},
                {new BigDecimal("12500"), new BigDecimal("1600.00")},
                {new BigDecimal("40000"), new BigDecimal("7300.00")}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void shouldComputeProgressiveTaxFromGivenSalary(BigDecimal income, BigDecimal expectedTax) {
        Map<Long, BigDecimal> m = getTaxBrackets();
        var calculator = new ProgressiveTaxCalculator(m);
        var actualTax = calculator.calculate(income);
        assertThat(actualTax).
                isEqualTo(expectedTax);
    }

    private Map<Long, BigDecimal> getTaxBrackets() {

        long x = Long.MAX_VALUE;

        Map<Long, BigDecimal> m = new LinkedHashMap<>();
        m.put(10_000L, new BigDecimal("0.11"));
        m.put(38_000L, new BigDecimal("0.20"));
        m.put(x, new BigDecimal("0.30"));
        return m;
    }
}
