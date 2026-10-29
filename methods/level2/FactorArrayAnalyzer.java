package level2;

import java.util.Scanner;

public class FactorArrayAnalyzer {

    // Find the proper factors and store them in an array
    public static int[] findFactors(int number) {
        if (number <= 1) {
            return new int[0];
        }

        // First loop: count the factors
        int count = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize the array with the required size
        int[] factors = new int[count];
        int index = 0;

        // Second loop: store the factors
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // Calculate the sum of factors
    public static long calculateSum(int[] factors) {
        long sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Calculate the product of factors
    public static long calculateProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Calculate the sum of squares using Math.pow()
    public static double calculateSumOfSquares(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Enter a positive integer.");
        } else {
            int[] factors = findFactors(number);

            System.out.print("Factors: ");
            for (int factor : factors) {
                System.out.print(factor + " ");
            }

            System.out.println("\nSum of factors: " + calculateSum(factors));
            System.out.println("Product of factors: "
                    + calculateProduct(factors));
            System.out.println("Sum of squares: "
                    + calculateSumOfSquares(factors));
        }

        input.close();
    }
}
