import java.util.Arrays;

public class BinarySearchFirstLastOccurrence {

    static int findFirst(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    static int findLast(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int first = findFirst(numbers, target);
        int last = findLast(numbers, target);

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("First occurrence: " + first);
        System.out.println("Last occurrence: " + last);
    }
}