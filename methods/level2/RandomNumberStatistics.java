package level2;

import java.util.Arrays;

public class RandomNumberStatistics {

    // Generate an array containing random four-digit numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            // Generate an integer between 1000 and 9999 inclusive
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }

        return numbers;
    }

    // Return average, minimum, and maximum in a double array
    public static double[] findAverageMinMax(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException(
                    "The array must not be empty.");
        }

        double sum = 0;
        int minimum = numbers[0];
        int maximum = numbers[0];

        // Calculate sum, minimum, and maximum
        for (int number : numbers) {
            sum += number;

            minimum = (int) Math.min(minimum, number);
            maximum = (int) Math.max(maximum, number);
        }

        // Calculate average
        double average = sum / numbers.length;

        // Return average, minimum, and maximum in this order
        return new double[]{average, minimum, maximum};
    }

    public static void main(String[] args) {
        // Generate five random four-digit numbers
        int[] numbers = generate4DigitRandomArray(5);

        // Calculate the statistics
        double[] statistics = findAverageMinMax(numbers);

        // Display the generated numbers and statistics
        System.out.println("Random four-digit numbers: "
                + Arrays.toString(numbers));

        System.out.printf("Average: %.2f%n", statistics[0]);
        System.out.printf("Minimum: %.0f%n", statistics[1]);
        System.out.printf("Maximum: %.0f%n", statistics[2]);
    }
}

