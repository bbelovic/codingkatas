package org.bbelovic.kata.euler;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeCheckerTest {
    @ParameterizedTest
    @MethodSource("testData")
    public void should_detect_palindrome(String wordToTest, boolean expectedResult) {
        PalindromeChecker checker = new PalindromeChecker();
        assertThat(checker.isPalindrome(wordToTest)).isEqualTo(expectedResult);
    }

    private static Object[][] testData() {
        return new Object[][] {
                {"radar", true},
                {"9009", true},
                {"eye", true},
                {"11", true},
                {"202", true},
                {"bridge", false},
                {"ok", false}
        };
    }
}
