public class FibonacciPerformanceComparison {

    // Naive recursive Fibonacci: O(2^n) time
    static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacciRecursive(n - 1)
                + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci: O(n) time, O(1) extra space
    static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0;
        long b = 1;

        for (int i = 2; i <= n; i++) {
            long sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    static void testRecursive(int n) {
        long start = System.nanoTime();
        long result = fibonacciRecursive(n);
        long elapsed = System.nanoTime() - start;

        System.out.println("Recursive n = " + n + ", result = " + result);
        System.out.printf("Recursive time: %.3f ms%n",
                elapsed / 1_000_000.0);
    }

    static void testIterative(int n) {
        long start = System.nanoTime();
        long result = fibonacciIterative(n);
        long elapsed = System.nanoTime() - start;

        System.out.println("Iterative n = " + n + ", result = " + result);
        System.out.printf("Iterative time: %.3f ms%n",
                elapsed / 1_000_000.0);
    }

    public static void main(String[] args) {
        // Naive recursion becomes expensive as n grows.
        testRecursive(30);

        System.out.println();

        // Iteration is efficient for much larger inputs.
        testIterative(50);
        testIterative(90);
    }
}