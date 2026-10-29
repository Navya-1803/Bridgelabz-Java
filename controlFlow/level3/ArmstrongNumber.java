package level3;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Store the original number for comparison
        int originalNumber = number;

        // Initialize the sum of digit cubes
        int sum = 0;

        // Work with a copy so the original number is preserved
        int temp = number;

        // Extract each digit and calculate its cube
        while (temp != 0) {
            int digit = temp % 10;

            // Add the cube of the digit to the sum
            sum += digit * digit * digit;

            // Remove the last digit
            temp = temp / 10;
        }

        // Compare the sum with the original number
        if (originalNumber >= 0 && sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }

        input.close();
    }
}