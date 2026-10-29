package level1;

import java.util.Scanner;

public class ArrayIndexExceptionDemo {

    // Deliberately access an index outside the array
    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    // Handle the invalid array index
    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("ArrayIndexOutOfBoundsException handled: "
                    + "invalid array index.");
        } catch (RuntimeException exception) {
            System.out.println("Other runtime exception handled: "
                    + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create an array to store three names
        String[] names = new String[3];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = input.next();
        }

        // Generate the exception
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Exception generated: "
                    + exception.getClass().getSimpleName());
        }

        // Handle the exception
        handleException(names);

        input.close();
    }
}
