import java.io.IOException;

// Custom checked exception
class InvalidDataException extends Exception {

    public InvalidDataException(String message) {
        super(message);
    }
}

public class CheckedUncheckedExample {

    static void processData(int value)
            throws IOException, InvalidDataException {

        if (value < 0) {
            throw new InvalidDataException(
                    "Negative values are not allowed"
            );
        }

        if (value == 0) {
            throw new IOException(
                    "Unable to process zero value"
            );
        }

        if (value > 100) {
            throw new IllegalArgumentException(
                    "Value exceeds the allowed limit"
            );
        }

        System.out.println("Data processed successfully: " + value);
    }

    public static void main(String[] args) {

        int value = 150;

        try {

            processData(value);

        } catch (InvalidDataException e) {

            System.out.println("Invalid data: " + e.getMessage());

        } catch (IOException e) {

            System.out.println("IO Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Runtime Error: " + e.getMessage());
        }
    }
}