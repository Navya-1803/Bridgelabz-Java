import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    static int findLongestSequence(int[] arr) {
        Set<Integer> numbers = new HashSet<>();

        for (int number : arr) {
            numbers.add(number);
        }

        int longest = 0;

        for (int number : numbers) {

            // Only start counting at the beginning of a sequence.
            if (number != Integer.MIN_VALUE
                    && numbers.contains(number - 1)) {
                continue;
            }

            int current = number;
            int length = 1;

            while (current != Integer.MAX_VALUE
                    && numbers.contains(current + 1)) {
                current++;
                length++;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2, 5};

        System.out.println(
                "Longest consecutive sequence length: "
                        + findLongestSequence(arr)
        );
    }
}