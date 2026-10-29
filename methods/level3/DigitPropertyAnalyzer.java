package level3;

import java.util.Arrays;
import java.util.Scanner;

public class DigitPropertyAnalyzer {

    // Count the digits in a non-negative integer
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;

        while (number > 0) {
            count++;
            number /= 10;
        }

        return count;
    }

    // Convert the number into an array of digits in original order
    public static int[] getDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // A duck number contains at least one zero after ignoring leading zeros
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }

        return false;
    }

    // Check Armstrong property using the digit array
    public static boolean isArmstrongNumber(int number, int[] digits) {
        long sum = 0;

        for (int digit : digits) {
            sum += (long) Math.pow(digit, digits.length);
        }

        return sum == number;
    }

    // Return largest and second-largest distinct digits
    public static int[] findLargestTwo(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit < largest && digit > secondLargest) {
                secondLargest = digit;
            }
        }

        return new int[]{largest, secondLargest};
    }

    // Return smallest and second-smallest distinct digits
    public static int[] findSmallestTwo(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit > smallest && digit < secondSmallest) {
                secondSmallest = digit;
            }
        }

        return new int[]{smallest, secondSmallest};
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

        int[] digits = getDigits(number);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Digit count: " + digits.length);
        System.out.println("Duck number: " + isDuckNumber(digits));
        System.out.println("Armstrong number: "
                + isArmstrongNumber(number, digits));

        int[] largest = findLargestTwo(digits);
        int[] smallest = findSmallestTwo(digits);

        System.out.println("Largest digit: " + largest[0]);
        System.out.println("Second-largest distinct digit: "
                + (largest[1] == Integer.MIN_VALUE
                ? "Not available" : largest[1]));

        System.out.println("Smallest digit: " + smallest[0]);
        System.out.println("Second-smallest distinct digit: "
                + (smallest[1] == Integer.MAX_VALUE
                ? "Not available" : smallest[1]));

        input.close();
    }
}