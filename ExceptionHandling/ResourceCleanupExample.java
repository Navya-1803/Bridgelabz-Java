// Simulated connection resource
class DatabaseConnection implements AutoCloseable {

    public DatabaseConnection() {
        System.out.println("Database connection opened");
    }

    public void executeQuery() {

        System.out.println("Executing database query");

        // Simulate an exception
        throw new RuntimeException("Database query failed");
    }

    // Automatically called by try-with-resources
    @Override
    public void close() {

        System.out.println("Database connection closed");
    }
}

public class ResourceCleanupExample {

    public static void main(String[] args) {

        try (DatabaseConnection connection =
                     new DatabaseConnection()) {

            connection.executeQuery();

        } catch (RuntimeException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            System.out.println("Program execution completed");
        }
    }
}