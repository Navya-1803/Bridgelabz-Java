package extra;

import java.util.Scanner;

public class MostFrequentCharacterFinder {

    // Find the character with the highest frequency
    public static char findMostFrequentCharacter(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException(
                    "The string must not be empty.");
        }

        char mostFrequent = text.charAt(0);
        int maximumFrequency = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            int frequency = 0;

            // Count occurrences of the current character
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == current) {
                    frequency++;
                }
            }

            if (frequency > maximumFrequency) {
                maximumFrequency = frequency;
                mostFrequent = current;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        if (text.isEmpty()) {
            System.out.println("Please enter a non-empty string.");
        } else {
            char result = findMostFrequentCharacter(text);

            System.out.println("Most Frequent Character: '" + result + "'");
        }

        input.close();
    }
}
