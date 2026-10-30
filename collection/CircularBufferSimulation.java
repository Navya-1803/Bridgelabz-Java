import java.util.Arrays;

public class CircularBufferSimulation {

    static class CircularBuffer {
        private final int[] buffer;
        private int front = 0;
        private int size = 0;

        CircularBuffer(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException(
                        "Capacity must be positive");
            }

            buffer = new int[capacity];
        }

        void add(int value) {
            if (size < buffer.length) {
                int rear = (front + size) % buffer.length;
                buffer[rear] = value;
                size++;
            } else {
                // Overwrite oldest element
                buffer[front] = value;
                front = (front + 1) % buffer.length;
            }
        }

        void display() {
            System.out.print("Buffer: [");

            for (int i = 0; i < size; i++) {
                System.out.print(buffer[(front + i) % buffer.length]);

                if (i < size - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        buffer.display();

        buffer.add(4);

        buffer.display();
    }
}