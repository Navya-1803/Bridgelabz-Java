package level3;

import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharacterExtractor {

    // Find the length without using String.length()
    public static int findStringLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            // Reaching the end of the string terminates counting
        }

        return count;
    }

    // Return characters that occur exactly once
    public static char[] findUniqueCharacters(String text) {
        int textLength = findStringLength(text);
        char[] temporary = new char[textLength];
        int uniqueCount = 0;

        // Check each character against every other character
        for (int i = 0; i < textLength; i++) {
            char current = text.charAt(i);
            int frequency = 0;

            for (int j = 0; j < textLength; j++) {
                if (text.charAt(j) == current) {
                    frequency++;
                }
            }

            // Store only characters that occur once
            if (frequency == 1) {
                temporary[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create an array containing only the unique characters
        char[] result = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temporary[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        char[] uniqueCharacters = findUniqueCharacters(text);

        System.out.println("Unique characters: "
                + Arrays.toString(uniqueCharacters));

        input.close();
    }
}
