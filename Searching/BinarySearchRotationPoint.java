public class BinarySearchRotationPoint {

    static int findRotationIndex(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            // Avoid possible integer overflow
            int mid = left + (right - left) / 2;

            if (numbers[mid] > numbers[right]) {
                // Smallest element lies to the right of mid
                left = mid + 1;
            } else {
                // Smallest element is at mid or to its left
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] numbers = {15, 18, 2, 3, 6, 12};

        int index = findRotationIndex(numbers);

        if (index != -1) {
            System.out.println("Rotation point index: " + index);
            System.out.println("Smallest element: " + numbers[index]);
        } else {
            System.out.println("Array is empty.");
        }
    }
}