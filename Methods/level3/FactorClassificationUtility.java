package level3;

import java.util.Arrays;
import java.util.Scanner;

public class FactorClassificationUtility {

    // Return all proper factors, excluding the number itself
    public static int[] findFactors(int number) {
        if (number <= 1) {
            return new int[0];
        }

        // First loop: count factors to determine array size
        int count = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Second loop: store the factors
        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Find the greatest proper factor
    public static int findGreatestFactor(int[] factors) {
        int greatest = 0;

        for (int factor : factors) {
            if (factor > greatest) {
                greatest = factor;
            }
        }

        return greatest;
    }

    // Sum all factors
    public static long sumFactors(int[] factors) {
        long sum = 0;

        for (int factor : factors) {
            sum += factor;
        }

        return sum;
    }

    // Multiply all factors
    public static long productFactors(int[] factors) {
        long product = 1;

        for (int factor : factors) {
            product *= factor;
        }

        return product;
    }

    // Sum the cubes of all factors
    public static double sumCubes(int[] factors) {
        double sum = 0;

        for (int factor : factors) {
            sum += Math.pow(factor, 3);
        }

        return sum;
    }

    // Perfect: sum of proper factors equals the number
    public static boolean isPerfect(int number, int[] factors) {
        return number > 0 && sumFactors(factors) == number;
    }

    // Abundant: sum of proper factors exceeds the number
    public static boolean isAbundant(int number, int[] factors) {
        return number > 0 && sumFactors(factors) > number;
    }

    // Deficient: sum of proper factors is less than the number
    public static boolean isDeficient(int number, int[] factors) {
        return number > 0 && sumFactors(factors) < number;
    }

    // Calculate factorial of one digit
    public static int factorial(int digit) {
        int result = 1;

        for (int i = 2; i <= digit; i++) {
            result *= i;
        }

        return result;
    }

    // Strong: sum of digit factorials equals the original number
    public static boolean isStrong(int number) {
        if (number < 0) {
            return false;
        }

        int temp = number;
        long sum = 0;

        do {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        } while (temp > 0);

        return sum == number;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return;
        }

        int[] factors = findFactors(number);

        System.out.println("Proper factors: " + Arrays.toString(factors));
        System.out.println("Greatest proper factor: "
                + findGreatestFactor(factors));
        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
        System.out.println("Sum of cubes: " + sumCubes(factors));
        System.out.println("Perfect: " + isPerfect(number, factors));
        System.out.println("Abundant: " + isAbundant(number, factors));
        System.out.println("Deficient: " + isDeficient(number, factors));
        System.out.println("Strong: " + isStrong(number));

        input.close();
    }
}