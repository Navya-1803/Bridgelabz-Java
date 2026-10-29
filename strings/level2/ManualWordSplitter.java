package level2;

import java.util.Arrays;
import java.util.Scanner;

public class ManualWordSplitter {

    // Find string length without using length()
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

    // Count words separated by whitespace
    public static int countWords(String text) {
        int wordCount = 0;
        boolean insideWord = false;

        for (int i = 0; i < findStringLength(text); i++) {
            char character = text.charAt(i);

            if (Character.isWhitespace(character)) {
                insideWord = false;
            } else if (!insideWord) {
                wordCount++;
                insideWord = true;
            }
        }

        return wordCount;
    }

    // Split text into words using charAt(), without split()
    public static String[] splitWords(String text) {
        int wordCount = countWords(text);
        String[] words = new String[wordCount];

        int wordIndex = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < findStringLength(text); i++) {
            char character = text.charAt(i);

            if (Character.isWhitespace(character)) {
                if (currentWord.length() > 0) {
                    words[wordIndex++] = currentWord.toString();
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(character);
            }
        }

        // Store the final word if the text does not end with whitespace
        if (currentWord.length() > 0) {
            words[wordIndex] = currentWord.toString();
        }

        return words;
    }

    // Compare two string arrays element by element
    public static boolean compareArrays(String[] first, String[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = input.nextLine();

        // User-defined splitting
        String[] customWords = splitWords(text);

        // Built-in splitting; handle empty or whitespace-only text
        String trimmedText = text.trim();
        String[] builtInWords = trimmedText.isEmpty()
                ? new String[0]
                : trimmedText.split("\\s+");

        System.out.println("Custom words: "
                + Arrays.toString(customWords));
        System.out.println("Built-in words: "
                + Arrays.toString(builtInWords));

        System.out.println("Both arrays match: "
                + compareArrays(customWords, builtInWords));

        input.close();
    }
}
