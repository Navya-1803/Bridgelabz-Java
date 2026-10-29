package level2;

import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer greater than 1: ");
        int number = input.nextInt();

        if (number <= 1) {
            System.out.println("Please enter an integer greater than 1.");
            input.close();
            return;
        }

        System.out.println("Proper factors of " + number + ":");

        // Check each number smaller than the input
        for (int i = 1; i < number; i++) {
            // A factor divides the number without a remainder
            if (number % i == 0) {
                System.out.println(i);
            }
        }

        input.close();
    }
}
