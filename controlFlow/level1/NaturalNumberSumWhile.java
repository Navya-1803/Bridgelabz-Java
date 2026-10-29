package level1;

import java.util.Scanner;

public class NaturalNumberSumWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number > 0) {
            // Calculate the sum using a while loop
            long loopSum = 0;
            int counter = 1;

            while (counter <= number) {
                loopSum += counter;
                counter++;
            }

            // Calculate the sum using the formula
            long formulaSum = (long) number * (number + 1L) / 2;

            System.out.println("Sum using while loop: " + loopSum);
            System.out.println("Sum using formula: " + formulaSum);

            // Compare both results
            if (loopSum == formulaSum) {
                System.out.println("Both results are equal.");
            } else {
                System.out.println("The results are different.");
            }
        } else {
            System.out.println("The number must be a natural number.");
        }

        input.close();
    }
}
