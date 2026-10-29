package level3;

import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Initialize the sum of proper divisors
        int sum = 0;

        if (number > 0) {
            // Check all numbers smaller than the input
            for (int i = 1; i < number; i++) {
                // Add i if it divides the number exactly
                if (number % i == 0) {
                    sum += i;
                }
            }

            // Compare the sum of divisors with the number
            if (sum > number) {
                System.out.println(number + " is an Abundant Number.");
            } else {
                System.out.println(number + " is not an Abundant Number.");
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        input.close();
    }
}
