package Multithreading;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumer {

    private static final int END_MARKER = -1;

    static class SharedResource {

        private final Queue<Integer> queue = new ArrayDeque<>();
        private final int capacity;

        public SharedResource(int capacity) {
            if (capacity < 1) {
                throw new IllegalArgumentException(
                        "Queue capacity must be positive.");
            }
            this.capacity = capacity;
        }

        public synchronized void produce(int task)
                throws InterruptedException {

            while (queue.size() == capacity) {
                wait();
            }

            queue.add(task);

            System.out.println(
                    "Produced task: " + task);

            notifyAll();
        }

        public synchronized int consume()
                throws InterruptedException {

            while (queue.isEmpty()) {
                wait();
            }

            int task = queue.remove();

            notifyAll();

            return task;
        }
    }

    static class Producer implements Runnable {

        private final SharedResource resource;
        private final int taskCount;
        private final List<Integer> producedTasks;

        public Producer(
                SharedResource resource,
                int taskCount,
                List<Integer> producedTasks) {

            this.resource = resource;
            this.taskCount = taskCount;
            this.producedTasks = producedTasks;
        }

        @Override
        public void run() {

            try {
                for (int i = 1; i <= taskCount; i++) {
                    resource.produce(i);
                    producedTasks.add(i);
                }

                resource.produce(END_MARKER);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted.");
            }
        }
    }

    static class Consumer implements Runnable {

        private final SharedResource resource;
        private final List<Integer> consumedTasks;

        public Consumer(
                SharedResource resource,
                List<Integer> consumedTasks) {

            this.resource = resource;
            this.consumedTasks = consumedTasks;
        }

        @Override
        public void run() {

            try {
                while (true) {

                    int task = resource.consume();

                    if (task == END_MARKER) {
                        System.out.println(
                                "Consumer received termination signal.");
                        break;
                    }

                    consumedTasks.add(task);

                    System.out.println(
                            "Consumed task: " + task);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted.");
            }
        }
    }

    static class Result {

        private final List<Integer> producedTasks;
        private final List<Integer> consumedTasks;

        public Result(
                List<Integer> producedTasks,
                List<Integer> consumedTasks) {

            this.producedTasks = new ArrayList<>(producedTasks);
            this.consumedTasks = new ArrayList<>(consumedTasks);
        }

        public List<Integer> getProducedTasks() {
            return new ArrayList<>(producedTasks);
        }

        public List<Integer> getConsumedTasks() {
            return new ArrayList<>(consumedTasks);
        }
    }

    public static Result execute(int taskCount, int capacity) {

        if (taskCount < 0) {
            throw new IllegalArgumentException(
                    "Task count cannot be negative.");
        }

        SharedResource resource = new SharedResource(capacity);

        List<Integer> producedTasks = new ArrayList<>();
        List<Integer> consumedTasks = new ArrayList<>();

        Thread producer = new Thread(
                new Producer(resource, taskCount, producedTasks),
                "Producer"
        );

        Thread consumer = new Thread(
                new Consumer(resource, consumedTasks),
                "Consumer"
        );

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();

        } catch (InterruptedException e) {
            producer.interrupt();
            consumer.interrupt();

            Thread.currentThread().interrupt();

            throw new RuntimeException(
                    "Main thread was interrupted.", e);
        }

        return new Result(producedTasks, consumedTasks);
    }

    public static void main(String[] args) {

        try {
            int taskCount = 10;
            int queueCapacity = 3;

            System.out.println("Producer-Consumer started");

            Result result = execute(taskCount, queueCapacity);

            System.out.println("\nAll tasks processed.");
            System.out.println(
                    "Total produced: "
                            + result.getProducedTasks().size());

            System.out.println(
                    "Total consumed: "
                            + result.getConsumedTasks().size());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(
                    "Unexpected error: " + e.getMessage());
        }
    }
}
