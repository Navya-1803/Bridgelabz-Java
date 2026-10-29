package level1;

import java.util.Scanner;

public class ChocolateDistribution {

    // Return quotient and remainder for equal distribution
    public static int[] findRemainderAndQuotient(
            int number, int divisor) {

        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        // Validate the inputs before performing division
        if (numberOfChocolates >= 0 && numberOfChildren > 0) {
            // Calculate the distribution using the method
            int[] result = findRemainderAndQuotient(
                    numberOfChocolates, numberOfChildren);

            System.out.println("Chocolates per child: " + result[0]);
            System.out.println("Remaining chocolates: " + result[1]);
        } else {
            System.out.println(
                    "Chocolates cannot be negative and children must be positive.");
        }

        input.close();
    }
}
