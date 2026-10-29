package level3;

import java.util.Scanner;

public class CharacterFrequencyAnagramChecker {

    // Check whether two strings are anagrams
    public static boolean areAnagrams(String first, String second) {
        // Anagrams must have the same length
        if (first.length() != second.length()) {
            return false;
        }

        // The PDF specifies a frequency array for 256 ASCII characters
        int[] firstFrequency = new int[256];
        int[] secondFrequency = new int[256];

        // Count character frequencies in the first string
        for (int i = 0; i < first.length(); i++) {
            char character = first.charAt(i);

            if (character >= 256) {
                throw new IllegalArgumentException(
                        "Only ASCII characters are supported.");
            }

            firstFrequency[character]++;
        }

        // Count character frequencies in the second string
        for (int i = 0; i < second.length(); i++) {
            char character = second.charAt(i);

            if (character >= 256) {
                throw new IllegalArgumentException(
                        "Only ASCII characters are supported.");
            }

            secondFrequency[character]++;
        }

        // Compare frequencies for all ASCII characters
        for (int i = 0; i < 256; i++) {
            if (firstFrequency[i] != secondFrequency[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String first = input.nextLine();

        System.out.print("Enter the second string: ");
        String second = input.nextLine();

        try {
            if (areAnagrams(first, second)) {
                System.out.println("The strings are anagrams.");
            } else {
                System.out.println("The strings are not anagrams.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}
