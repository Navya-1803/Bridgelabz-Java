package extra;

import java.util.Scanner;

public class SubstringOccurrenceCounter {

    // Count overlapping occurrences of a substring
    public static int countOccurrences(String text, String substring) {
        if (substring.isEmpty()) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i <= text.length() - substring.length(); i++) {
            boolean matches = true;

            // Compare the substring character by character
            for (int j = 0; j < substring.length(); j++) {
                if (text.charAt(i + j) != substring.charAt(j)) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String text = input.nextLine();

        System.out.print("Enter the substring to search: ");
        String substring = input.nextLine();

        int count = countOccurrences(text, substring);

        System.out.println("Number of occurrences: " + count);

        input.close();
    }
}
