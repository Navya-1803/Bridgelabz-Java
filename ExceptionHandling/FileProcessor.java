import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileProcessor {

    public void processFiles(List<String> filePaths) {

        for (String filePath : filePaths) {

            System.out.println("\nReading file: " + filePath);

            // Each file is automatically closed after processing
            try (BufferedReader reader =
                         new BufferedReader(new FileReader(filePath))) {

                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + filePath);
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        FileProcessor processor = new FileProcessor();

        List<String> files = List.of(
                "file1.txt",
                "file2.txt",
                "file3.txt"
        );

        processor.processFiles(files);
    }
}