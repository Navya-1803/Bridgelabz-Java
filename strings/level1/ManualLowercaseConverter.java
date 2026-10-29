package level1;

import java.util.Scanner;

public class ManualLowercaseConverter {

    // Convert uppercase English letters to lowercase manually
    public static String convertToLowercase(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            // Convert only uppercase English letters
            if (character >= 'A' && character <= 'Z') {
                character = (char) (character + 32);
            }

            result.append(character);
        }

        return result.toString();
    }

    // Compare two strings character by character
    public static boolean compareStrings(String first, String second) {
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

        System.out.print("Enter complete text: ");
        String text = input.nextLine();

        // User-defined lowercase conversion
        String customResult = convertToLowercase(text);

        // Built-in lowercase conversion
        String builtInResult = text.toLowerCase();

        System.out.println("Custom lowercase: " + customResult);
        System.out.println("Built-in lowercase: " + builtInResult);

        System.out.println("Both results match: "
                + compareStrings(customResult, builtInResult));

        input.close();
    }
}
