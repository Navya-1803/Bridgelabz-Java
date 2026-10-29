import java.util.Stack;

public class QueueUsingTwoStacks {

    static class StackQueue {
        private Stack<Integer> inputStack = new Stack<>();
        private Stack<Integer> outputStack = new Stack<>();

        // Enqueue: push into the input stack.
        void enqueue(int value) {
            inputStack.push(value);
            System.out.println("Enqueued: " + value);
        }

        // Transfer elements only when outputStack is empty.
        private void transferIfNeeded() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
        }

        // Dequeue: remove the oldest inserted element.
        int dequeue() {
            transferIfNeeded();

            if (outputStack.isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }

            return outputStack.pop();
        }

        int peek() {
            transferIfNeeded();

            if (outputStack.isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }

            return outputStack.peek();
        }

        boolean isEmpty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());

        queue.enqueue(40);

        while (!queue.isEmpty()) {
            System.out.println("Removed: " + queue.dequeue());
        }
    }
}