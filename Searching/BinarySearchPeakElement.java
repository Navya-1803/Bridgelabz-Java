public class BinarySearchPeakElement {

    static int findPeakIndex(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] < numbers[mid + 1]) {
                // An increasing slope means a peak exists to the right
                left = mid + 1;
            } else {
                // A peak exists at mid or to the left
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 7, 6, 4, 2};

        int peakIndex = findPeakIndex(numbers);

        if (peakIndex != -1) {
            System.out.println("Peak element: " + numbers[peakIndex]);
            System.out.println("Peak index: " + peakIndex);
        } else {
            System.out.println("Array is empty.");
        }
    }
}