import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveListDuplicates {

    static List<Integer> removeDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        for (int number : numbers) {
            uniqueNumbers.add(number);
        }

        return new ArrayList<>(uniqueNumbers);
    }

    public static void main(String[] args) {
        List<Integer> numbers =
                List.of(3, 1, 2, 2, 3, 4);

        System.out.println("Original list: " + numbers);
        System.out.println("Without duplicates: "
                + removeDuplicates(numbers));
    }
}