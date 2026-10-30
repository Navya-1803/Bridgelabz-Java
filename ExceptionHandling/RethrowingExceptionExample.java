public class RethrowingExceptionExample {

    // Performs division
    static int performDivision(int numerator, int denominator) {

        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return numerator / denominator;
    }

    // Calls performDivision and rethrows with additional context
    static int calculate(int numerator, int denominator) {

        try {
            return performDivision(numerator, denominator);

        } catch (ArithmeticException e) {

            throw new ArithmeticException(
                    "Calculation failed: Unable to divide "
                            + numerator + " by " + denominator
            );
        }
    }

    public static void main(String[] args) {

        try {
            int result = calculate(20, 0);

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}