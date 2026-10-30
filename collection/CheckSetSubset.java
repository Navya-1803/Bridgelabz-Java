import java.util.Set;

public class CheckSetSubset {

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(2, 3);
        Set<Integer> set2 = Set.of(1, 2, 3, 4);

        boolean isSubset = set2.containsAll(set1);

        System.out.println("Is set1 a subset of set2? " + isSubset);
    }
}