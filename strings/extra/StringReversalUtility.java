package extra;

import java.util.Scanner;

public class StringReversalUtility {

    // Reverse the string using a loop and charAt()
    public static String reverseString(String text) {
        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        System.out.println("Reversed string: " + reverseString(text));

        input.close();
    }
}
