package level3;

import java.util.Scanner;

public class AsciiCharacterFrequencyReport {

    // Calculate frequencies using ASCII values as array indexes
    public static int[] calculateFrequencies(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (character >= 256) {
                throw new IllegalArgumentException(
                        "Only ASCII characters are supported.");
            }

            frequency[character]++;
        }

        return frequency;
    }

    // Return a 2D array: character and its frequency
    public static String[][] getFrequencyTable(String text) {
        int[] frequency = calculateFrequencies(text);

        // Count distinct characters
        int distinctCount = 0;

        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                distinctCount++;
            }
        }

        String[][] result = new String[distinctCount][2];
        boolean[] added = new boolean[256];
        int row = 0;

        // Preserve the order of first appearance
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (!added[character]) {
                result[row][0] = String.valueOf(character);
                result[row][1] = String.valueOf(frequency[character]);

                added[character] = true;
                row++;
            }
        }

        return result;
    }

    // Display the character frequency table
    public static void displayFrequencyTable(String[][] table) {
        System.out.printf("%-15s %s%n", "Character", "Frequency");
        System.out.println("-------------------------");

        for (String[] row : table) {
            String character = row[0];

            if (character.equals(" ")) {
                character = "[space]";
            }

            System.out.printf("%-15s %s%n", character, row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        try {
            String[][] table = getFrequencyTable(text);
            displayFrequencyTable(table);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}
