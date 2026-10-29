package level1;

import java.util.Scanner;

public class NaturalNumberSumFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number > 0) {
            long loopSum = 0;

            // Calculate the sum using a for loop
            for (int i = 1; i <= number; i++) {
                loopSum += i;
            }

            // Calculate the sum using the mathematical formula
            long formulaSum = (long) number * (number + 1L) / 2;

            System.out.println("Sum using for loop: " + loopSum);
            System.out.println("Sum using formula: " + formulaSum);

            // Verify that both approaches produce the same result
            System.out.println(loopSum == formulaSum
                    ? "Both results are equal."
                    : "The results are different.");
        } else {
            System.out.println("The number must be a natural number.");
        }

        input.close();
    }
}
