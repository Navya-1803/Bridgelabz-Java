package level3;

import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Store the original number
        int originalNumber = number;
        int temp = number;
        int sum = 0;

        // Calculate the sum of the digits
        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            temp = temp / 10;
        }

        // A positive number must be divisible by its digit sum
        if (originalNumber > 0 && originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad number.");
        } else {
            System.out.println(originalNumber + " is not a Harshad number.");
        }

        input.close();
    }
}
