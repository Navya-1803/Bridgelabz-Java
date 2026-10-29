package level1;

import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number > 0) {
            // Calculate the sum using the mathematical formula
            long sum = (long) number * (number + 1L) / 2;

            System.out.println("The sum of " + number
                    + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + number
                    + " is not a natural number");
        }

        input.close();
    }
}
