package extra;

import java.util.Scanner;

public class SpecificCharacterRemover {

    // Remove every occurrence of the specified character
    public static String removeCharacter(String text, char target) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (current != target) {
                result += current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        System.out.print("Enter the character to remove: ");
        char target = input.nextLine().charAt(0);

        System.out.println("Modified String: "
                + removeCharacter(text, target));

        input.close();
    }
}
