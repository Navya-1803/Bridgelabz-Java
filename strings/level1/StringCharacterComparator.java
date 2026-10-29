package level1;

import java.util.Scanner;

public class StringCharacterComparator {

    // Compare two strings character by character
    public static boolean compareUsingCharAt(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String first = input.next();

        System.out.print("Enter the second string: ");
        String second = input.next();

        // Compare using the user-defined method
        boolean customResult = compareUsingCharAt(first, second);

        // Compare using Java's built-in equals() method
        boolean builtInResult = first.equals(second);

        System.out.println("Result using charAt(): " + customResult);
        System.out.println("Result using equals(): " + builtInResult);
        System.out.println("Both results match: "
                + (customResult == builtInResult));

        input.close();
    }
}
