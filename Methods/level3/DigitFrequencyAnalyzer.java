package level3;

import java.util.Scanner;

public class DigitFrequencyAnalyzer {

    // Count digits in a non-negative integer
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

    // Store digits in their original order
    public static int[] getDigits(int number) {
        int[] digits = new int[countDigits(number)];

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // Calculate the sum of digits
    public static int calculateDigitSum(int[] digits) {
        int sum = 0;

        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }

    // Calculate the sum of squares using Math.pow()
    public static double calculateSumOfSquares(int[] digits) {
        double sum = 0;

        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }

        return sum;
    }

    // A Harshad number is divisible by its digit sum
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = calculateDigitSum(digits);

        return number > 0 && sum != 0 && number % sum == 0;
    }

    // Return a 2D array: first column = digit, second column = frequency
    public static int[][] findDigitFrequency(int[] digits) {
        int[] frequency = new int[10];

        for (int digit : digits) {
            frequency[digit]++;
        }

        // Count how many different digits occur
        int distinctCount = 0;

        for (int count : frequency) {
            if (count > 0) {
                distinctCount++;
            }
        }

        int[][] result = new int[distinctCount][2];
        int row = 0;

        // Store only digits that occur at least once
        for (int digit = 0; digit <= 9; digit++) {
            if (frequency[digit] > 0) {
                result[row][0] = digit;
                result[row][1] = frequency[digit];
                row++;
            }
        }

        return result;
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

        System.out.println("Digit sum: " + calculateDigitSum(digits));
        System.out.println("Sum of squared digits: "
                + calculateSumOfSquares(digits));
        System.out.println("Harshad number: "
                + isHarshadNumber(number, digits));

        int[][] frequencies = findDigitFrequency(digits);

        System.out.println("Digit\tFrequency");

        for (int[] row : frequencies) {
            System.out.println(row[0] + "\t" + row[1]);
        }

        input.close();
    }
}
