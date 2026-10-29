package level3;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeMethodPalindromeChecker {

    // Method 1: Check palindrome using two pointers
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // Method 2: Check palindrome recursively
    public static boolean isPalindromeRecursive(
            String text, int start, int end) {

        // Base case: zero or one character remains
        if (start >= end) {
            return true;
        }

        // Characters at opposite ends must match
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Recursively check the remaining inner characters
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Reverse a string using charAt()
    public static char[] reverseString(String text) {
        char[] reversed = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }

        return reversed;
    }

    // Method 3: Compare the original and reversed character arrays
    public static boolean isPalindromeUsingArrays(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word or text: ");
        String text = input.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(
                text, 0, text.length() - 1);
        boolean arrayResult = isPalindromeUsingArrays(text);

        System.out.println("Palindrome using iterative method: "
                + iterativeResult);

        System.out.println("Palindrome using recursive method: "
                + recursiveResult);

        System.out.println("Palindrome using character arrays: "
                + arrayResult);

        input.close();
    }
}
