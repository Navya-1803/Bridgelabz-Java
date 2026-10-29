package extra;

import java.util.Scanner;

public class LongestWordFinder {

    // Find and return the longest word in a sentence
    public static String findLongestWord(String sentence) {
        String[] words = sentence.trim().split("\\s+");

        if (sentence.trim().isEmpty()) {
            return "";
        }

        String longestWord = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        String longestWord = findLongestWord(sentence);

        if (longestWord.isEmpty()) {
            System.out.println("No words found.");
        } else {
            System.out.println("Longest word: " + longestWord);
            System.out.println("Length: " + longestWord.length());
        }

        input.close();
    }
}
