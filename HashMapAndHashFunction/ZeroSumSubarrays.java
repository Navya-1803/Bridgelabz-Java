import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarrays {

    static void findAllZeroSumSubarrays(int[] arr) {
        // Maps a prefix sum to all earlier indices where it occurred.
        Map<Long, List<Integer>> prefixIndices = new HashMap<>();

        // Prefix sum zero before the array begins.
        prefixIndices.put(0L, new ArrayList<>());
        prefixIndices.get(0L).add(-1);

        long prefixSum = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixIndices.containsKey(prefixSum)) {
                for (int previousIndex : prefixIndices.get(prefixSum)) {
                    int start = previousIndex + 1;
                    int end = i;

                    System.out.println(
                            "Subarray: indices [" + start + ", " + end + "]"
                    );

                    found = true;
                }
            }

            prefixIndices
                    .computeIfAbsent(prefixSum, key -> new ArrayList<>())
                    .add(i);
        }

        if (!found) {
            System.out.println("No zero-sum subarrays found.");
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        System.out.println("Zero-sum subarrays:");
        findAllZeroSumSubarrays(arr);
    }
}