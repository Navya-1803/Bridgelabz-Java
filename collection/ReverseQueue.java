import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        int element = queue.remove();

        reverse(queue);

        queue.add(element);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original queue: " + queue);

        reverse(queue);

        System.out.println("Reversed queue: " + queue);
    }
}