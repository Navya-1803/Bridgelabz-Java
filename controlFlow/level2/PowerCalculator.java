package level2;

import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base number: ");
        int number = input.nextInt();

        System.out.print("Enter the power (non-negative integer): ");
        int power = input.nextInt();

        if (power < 0) {
            System.out.println("Please enter a non-negative power.");
            input.close();
            return;
        }

        // Start with 1 because any number raised to power 0 is 1
        long result = 1;

        // Multiply the result by the base once per iteration
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        System.out.println(number + " raised to the power "
                + power + " is " + result);

        input.close();
    }
}
