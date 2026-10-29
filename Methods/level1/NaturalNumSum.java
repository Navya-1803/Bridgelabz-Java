package level1;

import java.util.Scanner;

public class NaturalNumSum {

    // Calculate the sum from 1 to n using a loop
    public static long calculateSum(int number) {
        long sum = 0;

        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number > 0) {
            // Call the method to calculate the sum
            long sum = calculateSum(number);

            System.out.println("The sum of " + number
                    + " natural numbers is " + sum);
        } else {
            System.out.println("Please enter a positive integer.");
        }

        input.close();
    }
}
