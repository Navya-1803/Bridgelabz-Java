package extra;

import java.util.Scanner;

public class CharacterCaseToggler {

    // Toggle the case of each English alphabetic character
    public static String toggleCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                // Convert uppercase to lowercase
                ch = (char) (ch + 32);
            } else if (ch >= 'a' && ch <= 'z') {
                // Convert lowercase to uppercase
                ch = (char) (ch - 32);
            }

            result += ch;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        System.out.println("Toggled string: " + toggleCase(text));

        input.close();
    }
}
