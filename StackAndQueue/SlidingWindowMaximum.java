import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    static int[] findWindowMaximum(int[] arr, int k) {
        if (arr == null || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid window size.");
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window.
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Remove elements smaller than the current element.
            while (!deque.isEmpty()
                    && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            // The first complete window ends at index k - 1.
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = findWindowMaximum(arr, k);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Window size: " + k);
        System.out.println("Maximums: " + Arrays.toString(result));
    }
}