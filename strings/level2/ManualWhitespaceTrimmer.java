package level2;

import java.util.Scanner;

public class ManualWhitespaceTrimmer {

    // Return the length of a string without length()
    public static int findStringLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count++);
            }
        } catch (StringIndexOutOfBoundsException exception) {
            return count - 1;
        }
    }

    // Return start and end indexes after removing boundary whitespace
    // The end index is exclusive
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = findStringLength(text);

        // Skip leading whitespace
        while (start < end && Character.isWhitespace(text.charAt(start))) {
            start++;
        }

        // Skip trailing whitespace
        while (end > start && Character.isWhitespace(text.charAt(end - 1))) {
            end--;
        }

        return new int[]{start, end};
    }

    // Create a substring manually using charAt()
    public static String createSubstring(
            String text, int start, int end) {

        StringBuilder result = new StringBuilder();

        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }

        return result.toString();
    }

    // Compare strings character by character
    public static boolean compareStrings(String first, String second) {
        if (findStringLength(first) != findStringLength(second)) {
            return false;
        }

        for (int i = 0; i < findStringLength(first); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text with leading/trailing spaces: ");
        String text = input.nextLine();

        // Find the boundaries of the text
        int[] indexes = findTrimIndexes(text);

        // Create the trimmed text manually
        String customResult =
                createSubstring(text, indexes[0], indexes[1]);

        // Compare with the built-in trim() method
        String builtInResult = text.trim();

        System.out.println("Custom trimmed text: [" + customResult + "]");
        System.out.println("Built-in trimmed text: [" + builtInResult + "]");

        System.out.println("Both results match: "
                + compareStrings(customResult, builtInResult));

        input.close();
    }
}
