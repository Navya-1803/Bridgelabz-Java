import java.util.Arrays;

public class QuickSortProductPrices {

    // Partition the array using the last element as pivot
    static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;

                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Place pivot in its correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] prices = {499, 199, 799, 299, 99, 599};

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted product prices: "
                + Arrays.toString(prices));
    }
}