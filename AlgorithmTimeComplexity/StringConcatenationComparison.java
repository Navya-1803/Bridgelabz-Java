public class StringConcatenationComparison {

    static long testString(int repetitions) {
        String result = "";

        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            result += "hello";
        }

        long elapsed = System.nanoTime() - start;

        // Prevent the final result from being unused.
        System.out.println("String length: " + result.length());

        return elapsed;
    }

    static long testStringBuilder(int repetitions) {
        StringBuilder result = new StringBuilder();

        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            result.append("hello");
        }

        long elapsed = System.nanoTime() - start;

        System.out.println("StringBuilder length: " + result.length());

        return elapsed;
    }

    static long testStringBuffer(int repetitions) {
        StringBuffer result = new StringBuffer();

        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            result.append("hello");
        }

        long elapsed = System.nanoTime() - start;

        System.out.println("StringBuffer length: " + result.length());

        return elapsed;
    }

    static void printTime(String label, long nanoseconds) {
        System.out.printf("%s: %.3f ms%n",
                label, nanoseconds / 1_000_000.0);
    }

    public static void main(String[] args) {
        // Use a smaller count for immutable String concatenation.
        int stringRepetitions = 10_000;
        int mutableRepetitions = 1_000_000;

        System.out.println("--- Immutable String ---");
        printTime("String time",
                testString(stringRepetitions));

        System.out.println("\n--- StringBuilder ---");
        printTime("StringBuilder time",
                testStringBuilder(mutableRepetitions));

        System.out.println("\n--- StringBuffer ---");
        printTime("StringBuffer time",
                testStringBuffer(mutableRepetitions));

        System.out.println("\nNote: String was tested with fewer repetitions.");
    }
}