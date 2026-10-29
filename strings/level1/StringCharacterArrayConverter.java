package level1;

import java.util.Arrays;
import java.util.Scanner;

public class StringCharacterArrayConverter {

    // Convert a string into a character array manually
    public static char[] getCharacters(String text) {
        char[] characters = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }

        return characters;
    }

    // Compare two character arrays
    public static boolean compareArrays(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.next();

        // User-defined character array
        char[] customCharacters = getCharacters(text);

        // Built-in character array
        char[] builtInCharacters = text.toCharArray();

        System.out.println("Custom character array: "
                + Arrays.toString(customCharacters));

        System.out.println("Built-in character array: "
                + Arrays.toString(builtInCharacters));

        System.out.println("Both arrays match: "
                + compareArrays(customCharacters, builtInCharacters));

        input.close();
    }
}
