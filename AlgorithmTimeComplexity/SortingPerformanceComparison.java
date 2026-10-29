import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceComparison {

    static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    static void mergeSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(numbers, left, mid);
        mergeSort(numbers, mid + 1, right);

        merge(numbers, left, mid, right);
    }

    static void merge(int[] numbers, int left, int mid, int right) {
        int[] temporary = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (numbers[i] <= numbers[j]) {
                temporary[k++] = numbers[i++];
            } else {
                temporary[k++] = numbers[j++];
            }
        }

        while (i <= mid) {
            temporary[k++] = numbers[i++];
        }

        while (j <= right) {
            temporary[k++] = numbers[j++];
        }

        System.arraycopy(temporary, 0, numbers, left,
                temporary.length);
    }

    static void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(numbers, low, high);
        quickSort(numbers, low, pivotIndex - 1);
        quickSort(numbers, pivotIndex + 1, high);
    }

    static int partition(int[] numbers, int low, int high) {
        int pivot = numbers[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (numbers[j] <= pivot) {
                i++;
                swap(numbers, i, j);
            }
        }

        swap(numbers, i + 1, high);
        return i + 1;
    }

    static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    static double measureSort(int[] original, String algorithm) {
        int[] copy = original.clone();

        long start = System.nanoTime();

        switch (algorithm) {
            case "Bubble":
                bubbleSort(copy);
                break;
            case "Merge":
                mergeSort(copy, 0, copy.length - 1);
                break;
            case "Quick":
                quickSort(copy, 0, copy.length - 1);
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm");
        }

        long elapsed = System.nanoTime() - start;

        if (!isSorted(copy)) {
            throw new IllegalStateException("Sorting failed: " + algorithm);
        }

        return elapsed / 1_000_000.0;
    }

    static boolean isSorted(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        Random random = new Random(42);

        System.out.printf("%-12s %-20s %-20s %-20s%n",
                "Size", "Bubble (ms)", "Merge (ms)", "Quick (ms)");

        for (int size : sizes) {
            int[] numbers = new int[size];

            for (int i = 0; i < size; i++) {
                numbers[i] = random.nextInt(size * 10);
            }

            String bubbleResult;

            if (size <= 10_000) {
                bubbleResult = String.format("%.3f",
                        measureSort(numbers, "Bubble"));
            } else {
                bubbleResult = "Skipped";
            }

            double mergeTime = measureSort(numbers, "Merge");
            double quickTime = measureSort(numbers, "Quick");

            System.out.printf("%-12d %-20s %-20.3f %-20.3f%n",
                    size, bubbleResult, mergeTime, quickTime);
        }
    }
}