import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderLineByLine {
    public static void main(String[] args) {
        String fileName = "input.txt";

        // try-with-resources closes the reader automatically
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            // Read and print each line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}