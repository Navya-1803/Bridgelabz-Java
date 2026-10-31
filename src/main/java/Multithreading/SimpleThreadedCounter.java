package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleThreadedCounter {

    static class SharedCounter {

        private int current = 1;
        private final int limit;
        private final List<Integer> results = new ArrayList<>();

        public SharedCounter(int limit) {
            this.limit = limit;
        }

        public synchronized void count(int start, int end) {

            for (int number = start; number <= end; number++) {

                while (current != number) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                System.out.println(
                        Thread.currentThread().getName()
                                + " counted: " + current);

                results.add(current);
                current++;

                notifyAll();
            }
        }

        public synchronized List<Integer> getResults() {
            return new ArrayList<>(results);
        }
    }

    public static List<Integer> countNumbers(int limit, int threadCount) {

        if (limit < 1) {
            throw new IllegalArgumentException(
                    "Counting limit must be positive.");
        }

        if (threadCount < 1) {
            throw new IllegalArgumentException(
                    "Thread count must be positive.");
        }

        int actualThreads = Math.min(limit, threadCount);

        SharedCounter counter = new SharedCounter(limit);
        Thread[] threads = new Thread[actualThreads];

        int baseSize = limit / actualThreads;
        int remainder = limit % actualThreads;
        int start = 1;

        for (int i = 0; i < actualThreads; i++) {

            int portionSize = baseSize + (i < remainder ? 1 : 0);
            int end = start + portionSize - 1;

            int threadStart = start;
            int threadEnd = end;

            threads[i] = new Thread(
                    () -> counter.count(threadStart, threadEnd),
                    "Thread-" + (i + 1)
            );

            start = end + 1;
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(
                        "Main thread was interrupted.", e);
            }
        }

        return counter.getResults();
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the counting limit: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                return;
            }

            int limit = scanner.nextInt();

            System.out.print("Enter the number of threads: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid thread count.");
                return;
            }

            int threadCount = scanner.nextInt();

            List<Integer> results = countNumbers(limit, threadCount);

            System.out.println("Total numbers counted: " + results.size());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
