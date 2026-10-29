package level2;

import java.util.Scanner;

public class WordExtremesFinder {

    // Find string length using charAt()
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

    // Split text into words without using split()
    public static String[] splitWords(String text) {
        String[] temporaryWords = new String[findStringLength(text) + 1];
        int wordCount = 0;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < findStringLength(text); i++) {
            char character = text.charAt(i);

            if (Character.isWhitespace(character)) {
                if (word.length() > 0) {
                    temporaryWords[wordCount++] = word.toString();
                    word.setLength(0);
                }
            } else {
                word.append(character);
            }
        }

        if (word.length() > 0) {
            temporaryWords[wordCount++] = word.toString();
        }

        // Copy only the populated words into the final array
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            words[i] = temporaryWords[i];
        }

        return words;
    }

    // Create a 2D table: word and its length
    public static String[][] createWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findStringLength(words[i]));
        }

        return table;
    }

    // Return indexes of the shortest and longest words
    public static int[] findShortestAndLongest(String[][] table) {
        if (table.length == 0) {
            return new int[]{-1, -1};
        }

        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < table.length; i++) {
            int currentLength = Integer.parseInt(table[i][1]);
            int shortestLength = Integer.parseInt(table[shortestIndex][1]);
            int longestLength = Integer.parseInt(table[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }

            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = input.nextLine();

        String[] words = splitWords(text);
        String[][] table = createWordLengthTable(words);

        if (table.length == 0) {
            System.out.println("No words found.");
        } else {
            int[] indexes = findShortestAndLongest(table);

            System.out.println("Shortest word: " + table[indexes[0]][0]);
            System.out.println("Longest word: " + table[indexes[1]][0]);
        }

        input.close();
    }
}
