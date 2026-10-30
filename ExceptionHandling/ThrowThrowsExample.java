public class ThrowThrowsExample {

    // throws declares that this method may throw an exception
    static double calculateInterest(
            double amount, double rate, int years
    ) throws IllegalArgumentException {

        // throw explicitly generates an exception
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException(
                    "Invalid input: Amount and rate must be positive"
            );
        }

        // Simple interest calculation
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {

        try {
            double interest = calculateInterest(10000, 5, 2);

            System.out.println("Calculated interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}