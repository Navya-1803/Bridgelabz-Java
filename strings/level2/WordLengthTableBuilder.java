package level2;

import java.util.Scanner;

public class WordLengthTableBuilder {

    // Find length without using String.length()
    public static int findStringLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count++);
            }
        } catch (StringIndexOutOfBoundsException exception) {
            return count - 1;
        }
    }

    // Split the text into words using charAt()
    public static String[] splitWords(String text) {
        int totalCharacters = findStringLength(text);
        int wordCount = 0;
        boolean insideWord = false;

        // First pass: count the words
        for (int i = 0; i < totalCharacters; i++) {
            char character = text.charAt(i);

            if (Character.isWhitespace(character)) {
                insideWord = false;
            } else if (!insideWord) {
                wordCount++;
                insideWord = true;
            }
        }

        String[] words = new String[wordCount];
        StringBuilder word = new StringBuilder();
        int index = 0;

        // Second pass: extract the words
        for (int i = 0; i < totalCharacters; i++) {
            char character = text.charAt(i);

            if (Character.isWhitespace(character)) {
                if (word.length() > 0) {
                    words[index++] = word.toString();
                    word.setLength(0);
                }
            } else {
                word.append(character);
            }
        }

        if (word.length() > 0) {
            words[index] = word.toString();
        }

        return words;
    }

    // Create a 2D array containing each word and its length
    public static String[][] createWordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findStringLength(words[i]));
        }

        return result;
    }

    // Display the table, converting length from String to int
    public static void displayTable(String[][] table) {
        System.out.printf("%-20s %s%n", "Word", "Length");
        System.out.println("------------------------------");

        for (String[] row : table) {
            int wordLength = Integer.parseInt(row[1]);

            System.out.printf("%-20s %d%n", row[0], wordLength);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = input.nextLine();

        String[] words = splitWords(text);
        String[][] table = createWordLengthTable(words);

        displayTable(table);

        input.close();
    }
}
