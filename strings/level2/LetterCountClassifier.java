package level2;

import java.util.Scanner;

public class LetterCountClassifier {

    // Classify a character using ASCII-based case conversion
    public static String classifyCharacter(char character) {
        // Convert uppercase English letters to lowercase
        if (character >= 'A' && character <= 'Z') {
            character = (char) (character + 32);
        }

        // Ignore characters that are not English letters
        if (character < 'a' || character > 'z') {
            return "Not a Letter";
        }

        // Check whether the letter is a vowel
        if (character == 'a' || character == 'e'
                || character == 'i' || character == 'o'
                || character == 'u') {
            return "Vowel";
        }

        return "Consonant";
    }

    // Return the vowel count at index 0 and consonant count at index 1
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            String type = classifyCharacter(text.charAt(i));

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        int[] result = countVowelsAndConsonants(text);

        System.out.println("Vowel count: " + result[0]);
        System.out.println("Consonant count: " + result[1]);

        input.close();
    }
}
