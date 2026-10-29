package level2;

import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        // Check that the divisor is not zero
        if (number2 != 0) {
            // Integer division gives the quotient
            int quotient = number1 / number2;

            // Modulus gives the remainder
            int remainder = number1 % number2;

            System.out.println("The Quotient is " + quotient
                    + " and Remainder is " + remainder
                    + " of two numbers " + number1
                    + " and " + number2);
        } else {
            System.out.println("The second number cannot be zero.");
        }

        input.close();
    }
}
