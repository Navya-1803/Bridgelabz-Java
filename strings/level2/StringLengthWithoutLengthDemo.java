package level2;

import java.util.Scanner;

public class StringLengthWithoutLengthDemo {

    // Find string length without using length()
    public static int findStringLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            // The exception indicates that all characters were counted
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.next();

        // Calculate length using the user-defined method
        int customLength = findStringLength(text);

        // Calculate length using the built-in method
        int builtInLength = text.length();

        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using length(): " + builtInLength);
        System.out.println("Both results match: "
                + (customLength == builtInLength));

        input.close();
    }
}
