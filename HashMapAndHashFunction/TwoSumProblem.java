import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    // Returns indices of two distinct elements, or {-1, -1}.
    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check before inserting the current element.
            if (indexMap.containsKey(complement)) {
                return new int[] {indexMap.get(complement), i};
            }

            indexMap.put(arr[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);

        if (result[0] == -1) {
            System.out.println("No valid pair found.");
        } else {
            System.out.println("Indices: " + Arrays.toString(result));
            System.out.println(
                    "Values: " + arr[result[0]] + " and " + arr[result[1]]
            );
        }
    }
}