import java.util.LinkedList;
import java.util.ListIterator;

public class NthElementFromEnd {

    static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "N must be greater than zero");
        }

        ListIterator<T> fast = list.listIterator();
        ListIterator<T> slow = list.listIterator();

        // Move fast iterator n positions ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException(
                        "N exceeds the number of elements");
            }
            fast.next();
        }

        // Move both iterators together
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> names =
                new LinkedList<>(java.util.List.of(
                        "A", "B", "C", "D", "E"
                ));

        System.out.println("Nth element from end: "
                + findNthFromEnd(names, 2));
    }
}