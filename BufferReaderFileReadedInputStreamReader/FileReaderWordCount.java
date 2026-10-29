import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReaderWordCount {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String targetWord = "java";

        int count = 0;

        // Match words, ignoring case
        Pattern pattern = Pattern.compile(
                "\\b" + Pattern.quote(targetWord) + "\\b",
                Pattern.CASE_INSENSITIVE
        );

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    count++;
                }
            }

            System.out.println("Occurrences of '" + targetWord
                    + "': " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}