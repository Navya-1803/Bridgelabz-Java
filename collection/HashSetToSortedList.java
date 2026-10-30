import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetToSortedList {

    public static void main(String[] args) {
        Set<Integer> numbers =
                new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = new ArrayList<>(numbers);

        Collections.sort(sortedList);

        System.out.println("Sorted list: " + sortedList);
    }
}