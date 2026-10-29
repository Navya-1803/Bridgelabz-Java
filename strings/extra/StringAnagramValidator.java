package extra;

import java.util.Scanner;

public class StringAnagramValidator {

    // Return true if both strings contain the same characters
    public static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        // Frequency array for all possible Java char values
        int[] frequency = new int[Character.MAX_VALUE + 1];

        // Add frequencies from the first string
        for (int i = 0; i < first.length(); i++) {
            frequency[first.charAt(i)]++;
        }

        // Subtract frequencies using the second string
        for (int i = 0; i < second.length(); i++) {
            frequency[second.charAt(i)]--;
        }

        // Every character frequency must return to zero
        for (int count : frequency) {
            if (count != 0) {
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

        if (areAnagrams(first, second)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        input.close();
    }
}