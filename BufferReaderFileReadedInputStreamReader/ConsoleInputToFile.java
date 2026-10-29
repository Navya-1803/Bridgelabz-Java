import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConsoleInputToFile {
    public static void main(String[] args) {
        String fileName = "userInput.txt";

        // Read text from the console
        BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        // Open the output file and close it automatically
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, StandardCharsets.UTF_8))) {

            System.out.println("Enter text (type 'exit' to finish):");

            String line;

            while ((line = consoleReader.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                // Write each input as a separate line
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Input saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}