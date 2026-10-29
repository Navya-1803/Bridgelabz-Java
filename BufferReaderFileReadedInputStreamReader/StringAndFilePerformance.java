import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StringAndFilePerformance {

    // Benchmark StringBuilder
    static long testStringBuilder(int repetitions) {
        StringBuilder builder = new StringBuilder();

        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            builder.append("hello ");
        }

        long end = System.nanoTime();

        System.out.println("StringBuilder length: " + builder.length());
        return end - start;
    }

    // Benchmark StringBuffer
    static long testStringBuffer(int repetitions) {
        StringBuffer buffer = new StringBuffer();

        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            buffer.append("hello ");
        }

        long end = System.nanoTime();

        System.out.println("StringBuffer length: " + buffer.length());
        return end - start;
    }

    // Count words using a character reader
    static long countWords(BufferedReader reader) throws IOException {
        long wordCount = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String trimmed = line.trim();

            if (!trimmed.isEmpty()) {
                // Count whitespace-separated words
                wordCount += trimmed.split("\\s+").length;
            }
        }

        return wordCount;
    }

    // Read through FileReader using the platform default charset
    static long testFileReader(String fileName) throws IOException {
        long start = System.nanoTime();
        long words;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {
            words = countWords(reader);
        }

        long end = System.nanoTime();

        System.out.println("FileReader word count: " + words);
        return end - start;
    }

    // Read through InputStreamReader using explicit UTF-8
    static long testInputStreamReader(String fileName) throws IOException {
        long start = System.nanoTime();
        long words;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName),
                        StandardCharsets.UTF_8))) {
            words = countWords(reader);
        }

        long end = System.nanoTime();

        System.out.println("InputStreamReader word count: " + words);
        return end - start;
    }

    static void printTime(String label, long nanoseconds) {
        System.out.printf("%s: %.3f ms%n",
                label, nanoseconds / 1_000_000.0);
    }

    public static void main(String[] args) {
        int repetitions = 1_000_000;
        String fileName = "large.txt";

        // Part 1: String concatenation
        System.out.println("--- String Concatenation ---");

        long builderTime = testStringBuilder(repetitions);
        long bufferTime = testStringBuffer(repetitions);

        printTime("StringBuilder time", builderTime);
        printTime("StringBuffer time", bufferTime);

        // Part 2: File reading
        System.out.println("\n--- File Reading ---");

        try {
            long fileReaderTime = testFileReader(fileName);
            long inputStreamReaderTime =
                    testInputStreamReader(fileName);

            printTime("FileReader time", fileReaderTime);
            printTime("InputStreamReader time", inputStreamReaderTime);

        } catch (IOException e) {
            System.out.println("Could not read " + fileName
                    + ": " + e.getMessage());
            System.out.println(
                    "Create large.txt in the project's working directory.");
        }
    }
}