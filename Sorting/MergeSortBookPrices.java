import java.util.Arrays;

public class MergeSortBookPrices {

    // Divide the array into smaller parts
    static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            merge(prices, left, mid, right);
        }
    }

    // Merge two sorted sections
    static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Compare and copy the smaller element
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k++] = leftArray[i++];
            } else {
                prices[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            prices[k++] = leftArray[i++];
        }

        while (j < n2) {
            prices[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] prices = {450, 120, 700, 250, 90, 300};

        mergeSort(prices, 0, prices.length - 1);

        System.out.println("Sorted book prices: "
                + Arrays.toString(prices));
    }
}