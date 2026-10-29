package level1;

import java.util.Scanner;

public class QuotientRemainderCalculator {

    // Return quotient and remainder in an integer array
    public static int[] findRemainderAndQuotient(
            int number, int divisor) {

        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = input.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = input.nextInt();

        if (divisor != 0) {
            // Call the method
            int[] result = findRemainderAndQuotient(number, divisor);

            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        } else {
            System.out.println("Divisor cannot be zero.");
        }

        input.close();
    }
}
