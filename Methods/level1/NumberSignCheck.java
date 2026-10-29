package level1;

import java.util.Scanner;

public class NumberSignCheck {

    // Return 1 for positive, -1 for negative, and 0 for zero
    public static int checkNumber(int number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Get the result from the method
        int result = checkNumber(number);

        if (result == 1) {
            System.out.println(number + " is positive.");
        } else if (result == -1) {
            System.out.println(number + " is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        input.close();
    }
}
