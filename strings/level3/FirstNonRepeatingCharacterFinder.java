package level3;

import java.util.Scanner;

public class FirstNonRepeatingCharacterFinder {

    // Find the first non-repeating ASCII character
    public static char findFirstNonRepeatingCharacter(String text) {
        int[] frequency = new int[256];

        // Count the frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (character < 256) {
                frequency[character]++;
            } else {
                throw new IllegalArgumentException(
                        "This implementation supports ASCII characters only.");
            }
        }

        // Return the first character whose frequency is one
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (frequency[character] == 1) {
                return character;
            }
        }

        // Use a null character to indicate no result
        return '\0';
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        try {
            char result = findFirstNonRepeatingCharacter(text);

            if (result == '\0') {
                System.out.println("No non-repeating character found.");
            } else {
                System.out.println("First non-repeating character: " + result);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}
