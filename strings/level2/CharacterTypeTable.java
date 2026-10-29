package level2;

import java.util.Scanner;

public class CharacterTypeTable {

    // Determine whether a character is a vowel, consonant, or not a letter
    public static String classifyCharacter(char character) {
        // Convert uppercase ASCII letters to lowercase
        if (character >= 'A' && character <= 'Z') {
            character = (char) (character + 32);
        }

        if (character < 'a' || character > 'z') {
            return "Not a Letter";
        }

        if (character == 'a' || character == 'e'
                || character == 'i' || character == 'o'
                || character == 'u') {
            return "Vowel";
        }

        return "Consonant";
    }

    // Return a 2D array containing the character and its type
    public static String[][] classifyText(String text) {
        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            result[i][0] = String.valueOf(character);
            result[i][1] = classifyCharacter(character);
        }

        return result;
    }

    // Display character classifications in tabular format
    public static void displayTable(String[][] result) {
        System.out.printf("%-12s %s%n", "Character", "Type");
        System.out.println("-------------------------");

        for (String[] row : result) {
            String displayCharacter = row[0];

            if (displayCharacter.equals(" ")) {
                displayCharacter = "[space]";
            }

            System.out.printf("%-12s %s%n",
                    displayCharacter, row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] result = classifyText(text);

        displayTable(result);

        input.close();
    }
}
