package level2;

import java.util.Scanner;

public class GreatestProperFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer greater than 1: ");
        int number = input.nextInt();

        if (number <= 1) {
            System.out.println("Please enter an integer greater than 1.");
            input.close();
            return;
        }

        // Initialize the greatest proper factor
        int greatestFactor = 1;

        // Search downward from number - 1 to find the largest factor
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }

        System.out.println("The greatest factor of " + number
                + " besides itself is " + greatestFactor);

        input.close();
    }
}
