package level1;

import java.util.Scanner;

public class StringIndexExceptionDemo {

    // Deliberately access an invalid string index
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    // Handle the invalid index exception
    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("StringIndexOutOfBoundsException handled: "
                    + "index is outside the string.");
        } catch (RuntimeException exception) {
            System.out.println("Other runtime exception: "
                    + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.next();

        // Demonstrate the exception first
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Exception generated: "
                    + exception.getClass().getSimpleName());
        }

        // Now demonstrate exception handling
        handleException(text);

        input.close();
    }
}
