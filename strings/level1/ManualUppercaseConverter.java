package level1;

import java.util.Scanner;

public class ManualUppercaseConverter {

    // Convert lowercase English letters to uppercase manually
    public static String convertToUppercase(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            // Convert only lowercase English letters
            if (character >= 'a' && character <= 'z') {
                character = (char) (character - 32);
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

        // User-defined conversion
        String customResult = convertToUppercase(text);

        // Built-in conversion
        String builtInResult = text.toUpperCase();

        System.out.println("Custom uppercase: " + customResult);
        System.out.println("Built-in uppercase: " + builtInResult);

        System.out.println("Both results match: "
                + compareStrings(customResult, builtInResult));

        input.close();
    }
}
