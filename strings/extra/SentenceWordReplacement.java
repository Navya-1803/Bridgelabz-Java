package extra;

import java.util.Scanner;

public class SentenceWordReplacement {

    // Check whether a character is part of a word
    public static boolean isWordCharacter(char ch) {
        return (ch >= 'A' && ch <= 'Z')
                || (ch >= 'a' && ch <= 'z')
                || (ch >= '0' && ch <= '9')
                || ch == '_';
    }

    // Check whether the target word matches at a given position
    public static boolean matchesAt(
            String text, String target, int position) {

        if (position + target.length() > text.length()) {
            return false;
        }

        for (int i = 0; i < target.length(); i++) {
            if (text.charAt(position + i) != target.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // Replace all whole-word occurrences of target with replacement
    public static String replaceWord(
            String sentence, String target, String replacement) {

        if (target.isEmpty()) {
            throw new IllegalArgumentException(
                    "The target word must not be empty.");
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < sentence.length()) {
            // Check for the target at the current position
            if (matchesAt(sentence, target, i)) {
                int end = i + target.length();

                // Check the character before the target
                boolean validLeftBoundary = i == 0
                        || !isWordCharacter(sentence.charAt(i - 1));

                // Check the character after the target
                boolean validRightBoundary = end == sentence.length()
                        || !isWordCharacter(sentence.charAt(end));

                if (validLeftBoundary && validRightBoundary) {
                    result.append(replacement);
                    i = end;
                    continue;
                }
            }

            // Copy the current character when no whole-word match exists
            result.append(sentence.charAt(i));
            i++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        System.out.print("Enter the word to replace: ");
        String target = input.nextLine();

        System.out.print("Enter the replacement word: ");
        String replacement = input.nextLine();

        try {
            String modifiedSentence = replaceWord(
                    sentence, target, replacement);

            System.out.println("Modified sentence: " + modifiedSentence);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}
