package level3;

import java.util.Arrays;
import java.util.Scanner;

public class DigitPatternAnalyzer {

    // Convert a non-negative number into an array of digits
    public static int[] getDigits(int number) {
        String text = Integer.toString(number);
        int[] digits = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            digits[i] = text.charAt(i) - '0';
        }

        return digits;
    }

    // Reverse a digit array
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }

        return reversed;
    }

    // Compare two arrays element by element
    public static boolean areArraysEqual(int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }

    // A palindrome equals its reversed digit array
    public static boolean isPalindrome(int[] digits) {
        return areArraysEqual(digits, reverseDigits(digits));
    }

    // A duck number contains zero in its digits
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
            input.close();
            return;
        }

        int[] digits = getDigits(number);
        int[] reversed = reverseDigits(digits);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed digits: " + Arrays.toString(reversed));
        System.out.println("Palindrome: " + isPalindrome(digits));
        System.out.println("Duck number: " + isDuckNumber(digits));

        input.close();
    }
}

