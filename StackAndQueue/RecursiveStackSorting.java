import java.util.Stack;

public class RecursiveStackSorting {

    // Sorts the stack without using another collection.
    static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int value = stack.pop();

        sortStack(stack);

        insertInSortedOrder(stack, value);
    }

    // Inserts value so that the stack remains sorted.
    static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop();

        insertInSortedOrder(stack, value);

        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original stack (bottom to top): " + stack);

        sortStack(stack);

        System.out.println("Sorted stack (bottom to top): " + stack);
        System.out.println("Top element: " + stack.peek());
    }
}