import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapWordFrequencyCounter {

    static Map<String, Integer> countWords(String fileName)
            throws IOException {

        Map<String, Integer> frequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase()
                        .split("[^\\p{L}\\p{N}]+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        frequency.put(
                                word,
                                frequency.getOrDefault(word, 0) + 1
                        );
                    }
                }
            }
        }

        return frequency;
    }

    public static void main(String[] args) {
        String fileName = "words.txt";

        try {
            Map<String, Integer> result = countWords(fileName);
            System.out.println("Word frequency: " + result);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}