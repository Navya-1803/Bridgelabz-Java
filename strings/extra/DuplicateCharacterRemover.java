package extra;

import java.util.Scanner;

public class DuplicateCharacterRemover {

    // Remove repeated characters while preserving their first occurrence
    public static String removeDuplicates(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean alreadyExists = false;

            // Check whether the character is already in the result
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == current) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                result += current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        System.out.println("After removing duplicates: "
                + removeDuplicates(text));

        input.close();
    }
}
