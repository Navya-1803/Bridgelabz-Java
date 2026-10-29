package level2;

import java.util.Scanner;

public class NumberArrayAnalyzer {

    // Return true if the number is positive
    public static boolean isPositive(int number) {
        return number > 0;
    }

    // Return true if the number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Compare two numbers: 1 = greater, 0 = equal, -1 = smaller
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Store five user-entered numbers
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Analyze the sign and parity of every number
        for (int number : numbers) {
            if (isPositive(number)) {
                System.out.print(number + " is positive and ");

                if (isEven(number)) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else if (number < 0) {
                System.out.println(number + " is negative.");
            } else {
                System.out.println("The number is zero.");
            }
        }

        // Compare the first and last elements of the array
        int comparison = compare(numbers[0], numbers[numbers.length - 1]);

        if (comparison == 1) {
            System.out.println("First number is greater than the last.");
        } else if (comparison == 0) {
            System.out.println("First and last numbers are equal.");
        } else {
            System.out.println("First number is less than the last.");
        }

        input.close();
    }
}
