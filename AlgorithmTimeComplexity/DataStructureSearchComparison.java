import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class DataStructureSearchComparison {

    static boolean arraySearch(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }

        return false;
    }

    static double measureArray(int[] numbers, int target,
                               int repetitions) {
        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            arraySearch(numbers, target);
        }

        return (System.nanoTime() - start) / (double) repetitions;
    }

    static double measureHashSet(Set<Integer> numbers, int target,
                                 int repetitions) {
        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            numbers.contains(target);
        }

        return (System.nanoTime() - start) / (double) repetitions;
    }

    static double measureTreeSet(TreeSet<Integer> numbers, int target,
                                 int repetitions) {
        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            numbers.contains(target);
        }

        return (System.nanoTime() - start) / (double) repetitions;
    }

    static void printTime(String label, double nanoseconds) {
        System.out.printf("%s: %.3f microseconds per search%n",
                label, nanoseconds / 1_000.0);
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 100_000, 1_000_000};
        Random random = new Random(42);

        for (int size : sizes) {
            int[] numbers = new int[size];
            Set<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                numbers[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            int target = random.nextInt(size);
            int repetitions = size >= 1_000_000 ? 100 : 1_000;

            // Warm up collection lookup methods.
            for (int i = 0; i < 2_000; i++) {
                hashSet.contains(target);
                treeSet.contains(target);
            }

            System.out.println("\nDataset size: " + size);
            printTime("Array linear search",
                    measureArray(numbers, target, repetitions));
            printTime("HashSet search",
                    measureHashSet(hashSet, target, repetitions));
            printTime("TreeSet search",
                    measureTreeSet(treeSet, target, repetitions));
        }
    }
}