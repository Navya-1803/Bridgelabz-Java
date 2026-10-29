package level1;

import java.util.Scanner;
import java.util.Arrays;

public class SmallestLargestFinder {

    // Return an array containing the smallest and largest values
    public static int[] findSmallestAndLargest(
            int number1, int number2, int number3) {

        int smallest = number1;
        int largest = number1;

        // Compare the second number
        if (number2 < smallest) {
            smallest = number2;
        }
        if (number2 > largest) {
            largest = number2;
        }

        // Compare the third number
        if (number3 < smallest) {
            smallest = number3;
        }
        if (number3 > largest) {
            largest = number3;
        }

        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        System.out.print("Enter the third number: ");
        int number3 = input.nextInt();

        // Call the method and retrieve both results
        int[] result = findSmallestAndLargest(number1, number2, number3);

        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);

        input.close();
    }
}
