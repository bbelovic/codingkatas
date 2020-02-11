package org.bbelovic.kata.euler;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PalindromeCheckerTest {
    @Test
    public void should_detect_palindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        for (var target: List.of("radar", "9009", "eye", "202", "11")) {
            System.out.println("checking: " + target);
            Assert.assertTrue(checker.isPalindrome(target));
        }
        for (var target: List.of("ok")) {
            Assert.assertFalse(checker.isPalindrome(target));
        }
    }
}
