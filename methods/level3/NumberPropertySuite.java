package level3;

import java.util.Scanner;

public class NumberPropertySuite {

    // A prime number is greater than 1 and has no other divisors
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Sum the digits of a non-negative number
    public static int sumDigits(long number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    // Neon: the sum of the digits of the square equals the number
    public static boolean isNeon(int number) {
        if (number < 0) {
            return false;
        }

        long square = (long) number * number;
        return sumDigits(square) == number;
    }

    // Spy: the sum of digits equals their product
    public static boolean isSpy(int number) {
        if (number < 0) {
            return false;
        }

        int sum = 0;
        long product = 1;
        int temp = number;

        if (temp == 0) {
            return true; // Sum and product of the single digit 0 are both 0 here.
        }

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }

        return sum == product;
    }

    // Automorphic: the square ends with the original number
    public static boolean isAutomorphic(int number) {
        if (number < 0) {
            return false;
        }

        long square = (long) number * number;
        long divisor = 1;
        int temp = number;

        // Build 10 raised to the number of digits
        do {
            divisor *= 10;
            temp /= 10;
        } while (temp > 0);

        return square % divisor == number;
    }

    // Buzz: divisible by 7 or ends with 7
    public static boolean isBuzz(int number) {
        return number >= 0
                && (number % 7 == 0 || number % 10 == 7);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
            input.close();
            return;
        }

        System.out.println("Prime number: " + isPrime(number));
        System.out.println("Neon number: " + isNeon(number));
        System.out.println("Spy number: " + isSpy(number));
        System.out.println("Automorphic number: " + isAutomorphic(number));
        System.out.println("Buzz number: " + isBuzz(number));

        input.close();
    }
}
