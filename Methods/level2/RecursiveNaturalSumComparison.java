package level2;

import java.util.Scanner;

public class RecursiveNaturalSumComparison {

    // Calculate the sum recursively
    public static long calculateRecursiveSum(int number) {
        if (number == 0) {
            return 0;
        }

        // Add the current number to the sum of previous numbers
        return number + calculateRecursiveSum(number - 1);
    }

    // Calculate the sum using the mathematical formula
    public static long calculateFormulaSum(int number) {
        return (long) number * (number + 1L) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a natural number greater than zero.");
        } else if (number > 10000) {
            System.out.println("Number is too large for this recursive example.");
        } else {
            long recursiveSum = calculateRecursiveSum(number);
            long formulaSum = calculateFormulaSum(number);

            System.out.println("Sum using recursion: " + recursiveSum);
            System.out.println("Sum using formula: " + formulaSum);

            // Compare both results
            if (recursiveSum == formulaSum) {
                System.out.println("Both results are correct and equal.");
            } else {
                System.out.println("The results do not match.");
            }
        }

        input.close();
    }
}
