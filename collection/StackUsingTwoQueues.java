import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    static class MyStack {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        void push(int value) {
            // Insert new element into the empty queue
            queue2.add(value);

            // Move existing elements behind the new element
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }

            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        int pop() {
            if (queue1.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            return queue1.remove();
        }

        int top() {
            if (queue1.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            return queue1.peek();
        }

        boolean isEmpty() {
            return queue1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("New top: " + stack.top());
    }
}