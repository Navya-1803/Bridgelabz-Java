package level1;

import java.util.Scanner;

public class SubstringArgumentExceptionDemo {

    // Deliberately throw IllegalArgumentException for invalid indexes
    public static void generateException(String text) {
        int startIndex = 4;
        int endIndex = 2;

        if (startIndex > endIndex) {
            throw new IllegalArgumentException(
                    "Start index must not exceed end index.");
        }

        System.out.println(text.substring(startIndex, endIndex));
    }

    // Handle IllegalArgumentException and other runtime exceptions
    public static void handleException(String text) {
        int startIndex = 4;
        int endIndex = 2;

        try {
            if (startIndex > endIndex) {
                throw new IllegalArgumentException(
                        "Start index must not exceed end index.");
            }

            System.out.println(text.substring(startIndex, endIndex));
        } catch (IllegalArgumentException exception) {
            System.out.println("IllegalArgumentException handled: "
                    + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Other runtime exception handled: "
                    + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string with at least 5 characters: ");
        String text = input.next();

        if (text.length() < 5) {
            System.out.println("Please enter at least 5 characters.");
            input.close();
            return;
        }

        // Generate the exception
        try {
            generateException(text);
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception generated: "
                    + exception.getClass().getSimpleName());
        }

        // Handle the exception
        handleException(text);

        input.close();
    }
}
