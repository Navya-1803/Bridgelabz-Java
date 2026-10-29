package extra;

import java.util.Scanner;

public class LexicographicalStringComparator {

    // Return a negative value, zero, or a positive value
    public static int compareStrings(String first, String second) {
        int minLength = Math.min(first.length(), second.length());

        for (int i = 0; i < minLength; i++) {
            char ch1 = first.charAt(i);
            char ch2 = second.charAt(i);

            if (ch1 != ch2) {
                return ch1 - ch2;
            }
        }

        // All common characters match; compare string lengths
        return first.length() - second.length();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String first = input.nextLine();

        System.out.print("Enter the second string: ");
        String second = input.nextLine();

        int result = compareStrings(first, second);

        if (result < 0) {
            System.out.println("\"" + first
                    + "\" comes before \"" + second
                    + "\" in lexicographical order.");
        } else if (result > 0) {
            System.out.println("\"" + first
                    + "\" comes after \"" + second
                    + "\" in lexicographical order.");
        } else {
            System.out.println("Both strings are equal.");
        }

        input.close();
    }
}
