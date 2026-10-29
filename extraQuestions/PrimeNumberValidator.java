import java.util.Scanner;

public class PrimeNumberValidator {

    // Check whether a number is prime
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        // Check divisors only up to the square root of the number
        for (int divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        input.close();
    }
}