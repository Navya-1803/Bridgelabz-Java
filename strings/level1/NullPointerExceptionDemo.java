package level1;

public class NullPointerExceptionDemo {

    // Deliberately generate a NullPointerException
    public static void generateException() {
        String text = null;

        // Calling length() on null throws NullPointerException
        System.out.println(text.length());
    }

    // Demonstrate handling the exception
    public static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException exception) {
            System.out.println("NullPointerException handled: "
                    + "the string reference is null.");
        }
    }

    public static void main(String[] args) {
        // Demonstrate the exception without handling it in the method
        try {
            generateException();
        } catch (NullPointerException exception) {
            System.out.println("Uncaught demonstration: "
                    + exception.getClass().getSimpleName());
        }

        // Demonstrate the handled version
        handleException();
    }
}
