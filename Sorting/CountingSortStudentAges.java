import java.util.Arrays;

public class CountingSortStudentAges {

    static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count the frequency of each age
        for (int age : ages) {
            if (age < minAge || age > maxAge) {
                throw new IllegalArgumentException(
                        "Age must be between 10 and 18");
            }

            count[age - minAge]++;
        }

        // Compute cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Place ages in their correct positions
        // Traverse backward to preserve stability
        for (int i = ages.length - 1; i >= 0; i--) {
            int index = ages[i] - minAge;
            output[count[index] - 1] = ages[i];
            count[index]--;
        }

        // Copy sorted ages back into the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] ages = {15, 12, 18, 10, 14, 12, 16, 11};

        countingSort(ages);

        System.out.println("Sorted student ages: "
                + Arrays.toString(ages));
    }
}