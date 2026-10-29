package level1;

import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Deliberately parse invalid numeric text
    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    // Handle NumberFormatException and other runtime exceptions
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted integer: " + number);
        } catch (NumberFormatException exception) {
            System.out.println("NumberFormatException handled: "
                    + "input is not a valid integer.");
        } catch (RuntimeException exception) {
            System.out.println("Other runtime exception handled: "
                    + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text to convert into an integer: ");
        String text = input.next();

        // Demonstrate the exception
        try {
            generateException(text);
        } catch (NumberFormatException exception) {
            System.out.println("Exception generated: "
                    + exception.getClass().getSimpleName());
        }

        // Demonstrate exception handling
        handleException(text);

        input.close();
    }
}
