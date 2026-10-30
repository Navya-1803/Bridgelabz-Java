import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseListOperations {

    static <T> void reverseList(List<T> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList =
                new ArrayList<>(List.of(1, 2, 3, 4, 5));

        LinkedList<Integer> linkedList =
                new LinkedList<>(List.of(1, 2, 3, 4, 5));

        reverseList(arrayList);
        reverseList(linkedList);

        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}