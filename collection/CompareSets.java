import java.util.Set;

public class CompareSets {

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 2, 1);

        System.out.println("Are sets equal: " + set1.equals(set2));
    }
}