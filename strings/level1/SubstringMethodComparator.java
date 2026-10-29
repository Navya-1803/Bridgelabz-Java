package level1;

import java.util.Scanner;

public class SubstringMethodComparator {

    // Create a substring manually using charAt()
    public static String createSubstring(
            String text, int startIndex, int endIndex) {

        StringBuilder result = new StringBuilder();

        for (int i = startIndex; i < endIndex; i++) {
            result.append(text.charAt(i));
        }

        return result.toString();
    }

    // Compare two strings using charAt()
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

        System.out.print("Enter a string: ");
        String text = input.next();

        System.out.print("Enter start index: ");
        int startIndex = input.nextInt();

        System.out.print("Enter end index: ");
        int endIndex = input.nextInt();

        // Validate the substring boundaries
        if (startIndex < 0 || endIndex < startIndex
                || endIndex > text.length()) {
            System.out.println("Invalid substring indexes.");
            input.close();
            return;
        }

        String customSubstring =
                createSubstring(text, startIndex, endIndex);

        String builtInSubstring =
                text.substring(startIndex, endIndex);

        System.out.println("Substring using charAt(): " + customSubstring);
        System.out.println("Substring using substring(): " + builtInSubstring);

        System.out.println("Both substrings match: "
                + compareStrings(customSubstring, builtInSubstring));

        input.close();
    }
}
