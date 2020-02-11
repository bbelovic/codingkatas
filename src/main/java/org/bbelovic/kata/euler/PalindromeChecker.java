package org.bbelovic.kata.euler;

public class PalindromeChecker {
    public boolean isPalindrome(String wordToCheck) {
        char[] chars = wordToCheck.toCharArray();
        int m = chars.length / 2;
        var result = true;
        for (var i = 0; i <= m; i++) {
            var first = chars[i];
            var last = chars[chars.length - 1 - i];
            if (last != first) {
                result = false;
                break;
            }
        }
        return result;
    }
}
