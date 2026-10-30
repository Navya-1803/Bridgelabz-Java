import java.util.HashSet;
import java.util.Set;

public class SetSymmetricDifference {

    static Set<Integer> symmetricDifference(
            Set<Integer> set1, Set<Integer> set2) {

        Set<Integer> result = new HashSet<>(set1);

        // Add elements from set2
        result.addAll(set2);

        // Remove elements common to both sets
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);

        result.removeAll(common);

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 4, 5);

        System.out.println(
                "Symmetric difference: "
                        + symmetricDifference(set1, set2));
    }
}