import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileReadingPerformanceComparison {

    static long countWords(BufferedReader reader) throws IOException {
        long words = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String trimmed = line.trim();

            if (!trimmed.isEmpty()) {
                words += trimmed.split("\\s+").length;
            }
        }

        return words;
    }

    static void testFileReader(String fileName) throws IOException {
        long start = System.nanoTime();
        long wordCount;

        // Java 17+: specify UTF-8 explicitly
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName, StandardCharsets.UTF_8))) {
            wordCount = countWords(reader);
        }

        long elapsed = System.nanoTime() - start;

        System.out.println("FileReader word count: " + wordCount);
        System.out.printf("FileReader time: %.3f ms%n",
                elapsed / 1_000_000.0);
    }

    static void testInputStreamReader(String fileName)
            throws IOException {
        long start = System.nanoTime();
        long wordCount;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName),
                        StandardCharsets.UTF_8))) {
            wordCount = countWords(reader);
        }

        long elapsed = System.nanoTime() - start;

        System.out.println("InputStreamReader word count: " + wordCount);
        System.out.printf("InputStreamReader time: %.3f ms%n",
                elapsed / 1_000_000.0);
    }

    public static void main(String[] args) {
        String fileName = "large.txt";

        try {
            System.out.println("--- FileReader ---");
            testFileReader(fileName);

            System.out.println("\n--- InputStreamReader ---");
            testInputStreamReader(fileName);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            System.out.println(
                    "Create large.txt in the working directory first.");
        }
    }
}