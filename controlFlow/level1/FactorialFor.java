package level1;

import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative integers.");
        } else if (number > 20) {
            System.out.println("Please enter a number from 0 to 20.");
        } else {
            long factorial = 1;

            // Calculate factorial using a for loop
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("The factorial of " + number
                    + " is " + factorial);
        }

        input.close();
    }
}
