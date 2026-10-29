import java.util.Arrays;
import java.util.Random;

public class SearchPerformanceComparison {

    static int linearSearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    static double measureLinearSearch(int[] numbers, int target,
                                      int repetitions) {
        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            linearSearch(numbers, target);
        }

        return (System.nanoTime() - start) / (double) repetitions;
    }

    static double measureBinarySearch(int[] numbers, int target,
                                      int repetitions) {
        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            binarySearch(numbers, target);
        }

        return (System.nanoTime() - start) / (double) repetitions;
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        Random random = new Random(42);

        System.out.printf("%-12s %-20s %-20s %-20s%n",
                "Size", "Linear (us)", "Binary (us)", "Sort (ms)");

        for (int size : sizes) {
            int[] numbers = new int[size];

            for (int i = 0; i < size; i++) {
                numbers[i] = random.nextInt(size * 10);
            }

            // Use the middle element as a target guaranteed to exist.
            int target = numbers[size / 2];

            // Linear search uses the original unsorted array.
            int[] sortedNumbers = numbers.clone();

            long sortStart = System.nanoTime();
            Arrays.sort(sortedNumbers);
            long sortTime = System.nanoTime() - sortStart;

            // Warm up both methods.
            for (int i = 0; i < 2_000; i++) {
                linearSearch(numbers, target);
                binarySearch(sortedNumbers, target);
            }

            int repetitions = size >= 1_000_000 ? 100 : 2_000;

            double linearTime = measureLinearSearch(
                    numbers, target, repetitions);
            double binaryTime = measureBinarySearch(
                    sortedNumbers, target, repetitions);

            System.out.printf("%-12d %-20.3f %-20.3f %-20.3f%n",
                    size,
                    linearTime / 1_000.0,
                    binaryTime / 1_000.0,
                    sortTime / 1_000_000.0);
        }
    }
}