package level3;

import java.util.Scanner;

public class UniqueBasedFrequencyAnalyzer {

    // Find unique characters in order of first appearance
    public static char[] findUniqueCharacters(String text) {
        char[] temporary = new char[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean alreadyExists = false;

            // Check whether the character has already been stored
            for (int j = 0; j < uniqueCount; j++) {
                if (temporary[j] == current) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                temporary[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create the final array with the exact number of unique characters
        char[] uniqueCharacters = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            uniqueCharacters[i] = temporary[i];
        }

        return uniqueCharacters;
    }

    // Count the frequency of a particular character using charAt()
    public static int countFrequency(String text, char character) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == character) {
                count++;
            }
        }

        return count;
    }

    // Return unique characters and their frequencies in a 2D array
    public static String[][] getFrequencyTable(String text) {
        char[] uniqueCharacters = findUniqueCharacters(text);
        String[][] result = new String[uniqueCharacters.length][2];

        for (int i = 0; i < uniqueCharacters.length; i++) {
            char character = uniqueCharacters[i];

            result[i][0] = String.valueOf(character);
            result[i][1] = String.valueOf(
                    countFrequency(text, character));
        }

        return result;
    }

    // Display the results in tabular format
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

        String[][] table = getFrequencyTable(text);
        displayFrequencyTable(table);

        input.close();
    }
}
