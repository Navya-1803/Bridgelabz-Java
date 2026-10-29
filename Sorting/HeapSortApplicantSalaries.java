import java.util.Arrays;

public class HeapSortApplicantSalaries {

    // Restore the max-heap property
    static void heapify(int[] salaries, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < size && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != root) {
            int temp = salaries[root];
            salaries[root] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, size, largest);
        }
    }

    static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Move the largest element to the end repeatedly
        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Restore the heap for the remaining elements
            heapify(salaries, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {80000, 50000, 95000, 60000, 75000};

        heapSort(salaries);

        System.out.println("Sorted salary demands: "
                + Arrays.toString(salaries));
    }
}