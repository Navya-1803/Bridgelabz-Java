import java.util.Scanner;

public class GcdLcmCalculator {

    // Find the GCD using the Euclidean algorithm
    public static long calculateGcd(long first, long second) {
        first = Math.abs(first);
        second = Math.abs(second);

        while (second != 0) {
            long remainder = first % second;
            first = second;
            second = remainder;
        }

        return first;
    }

    // Calculate the LCM using the GCD
    public static long calculateLcm(long first, long second) {
        if (first == 0 || second == 0) {
            return 0;
        }

        long gcd = calculateGcd(first, second);

        // Divide before multiplying to reduce overflow risk
        return Math.abs((first / gcd) * second);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        long first = input.nextLong();

        System.out.print("Enter the second integer: ");
        long second = input.nextLong();

        System.out.println("GCD: " + calculateGcd(first, second));
        System.out.println("LCM: " + calculateLcm(first, second));

        input.close();
    }
}