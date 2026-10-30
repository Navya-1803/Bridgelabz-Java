import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

    public static void main(String[] args) {

        // Resource is automatically closed after try block
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("info.txt"))) {

            String line = reader.readLine();

            System.out.println("First line: " + line);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}