package level3;

import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Use a temporary variable to preserve the input
        int temp = number;
        int count = 0;

        // Count the digits by removing one digit per iteration
        while (temp != 0) {
            temp = temp / 10;
            count++;
        }

        // Zero itself has one digit
        if (number == 0) {
            count = 1;
        }

        System.out.println("The number of digits in "
                + number + " is " + count);

        input.close();
    }
}
