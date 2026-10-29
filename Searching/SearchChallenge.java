import java.util.Arrays;

public class SearchChallenge {

    // Find the smallest missing positive integer
    static int findFirstMissingPositive(int[] numbers) {
        int n = numbers.length;

        // Only values from 1 through n can all be present
        // without the first missing positive being at most n + 1.
        boolean[] present = new boolean[n + 1];

        for (int number : numbers) {
            if (number >= 1 && number <= n) {
                present[number] = true;
            }
        }

        // Linear search for the first missing positive
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    // Binary search in a sorted array
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

    public static void main(String[] args) {
        int[] numbers = {3, 4, -1, 1, 6, 2};
        int target = 4;

        int missingPositive = findFirstMissingPositive(numbers);

        // Sort a copy so the original array remains unchanged
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);

        int targetIndex = binarySearch(sortedNumbers, target);

        System.out.println("Original array: "
                + Arrays.toString(numbers));

        System.out.println("First missing positive: "
                + missingPositive);

        System.out.println("Sorted array: "
                + Arrays.toString(sortedNumbers));

        System.out.println("Target index in sorted array: "
                + targetIndex);
    }
}