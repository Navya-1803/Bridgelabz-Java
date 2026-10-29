package level2;

import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        boolean isPrime = number > 1;

        // Check whether any number from 2 to number - 1 divides it
        for (int i = 2; i < number && isPrime; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        // Display the result
        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        input.close();
    }
}
