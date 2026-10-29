import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {

    static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> visited = new HashSet<>();

        for (int number : arr) {
            int complement = target - number;

            if (visited.contains(complement)) {
                System.out.println(
                        "Pair found: " + complement + " + " + number
                                + " = " + target
                );
                return true;
            }

            visited.add(number);
        }

        System.out.println("No pair found.");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        hasPairWithSum(arr, target);
    }
}