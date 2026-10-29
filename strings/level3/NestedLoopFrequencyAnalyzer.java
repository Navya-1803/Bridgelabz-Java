package level3;

import java.util.Scanner;

public class NestedLoopFrequencyAnalyzer {

    // Return a 1D String array containing character-frequency pairs
    public static String[] findCharacterFrequencies(String text) {
        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];

        // Use nested loops to count occurrences
        for (int i = 0; i < characters.length; i++) {
            // Skip characters already marked as processed
            if (characters[i] == '\0') {
                continue;
            }

            frequency[i] = 1;

            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '\0'; // Mark duplicate
                }
            }
        }

        // Count the characters that have not been marked
        int distinctCount = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '\0') {
                distinctCount++;
            }
        }

        // Store character and frequency as adjacent array elements
        String[] result = new String[distinctCount * 2];
        int index = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '\0') {
                result[index++] = String.valueOf(characters[i]);
                result[index++] = String.valueOf(frequency[i]);
            }
        }

        return result;
    }

    // Display character-frequency pairs
    public static void displayFrequencies(String[] result) {
        System.out.printf("%-15s %s%n", "Character", "Frequency");
        System.out.println("-------------------------");

        for (int i = 0; i < result.length; i += 2) {
            String character = result[i];

            if (character.equals(" ")) {
                character = "[space]";
            }

            System.out.printf("%-15s %s%n",
                    character, result[i + 1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[] result = findCharacterFrequencies(text);
        displayFrequencies(result);

        input.close();
    }
}
