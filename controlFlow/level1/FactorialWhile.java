package level1;

import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        // Factorial is defined for non-negative integers
        if (number < 0) {
            System.out.println("Factorial is not defined for negative integers.");
        } else if (number > 20) {
            System.out.println("Please enter a number from 0 to 20.");
        } else {
            long factorial = 1;
            int counter = 1;

            // Multiply all integers from 1 through number
            while (counter <= number) {
                factorial *= counter;
                counter++;
            }

            System.out.println("The factorial of " + number
                    + " is " + factorial);
        }

        input.close();
    }
}
