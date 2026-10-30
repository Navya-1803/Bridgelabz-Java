// Custom transaction exception
class TransactionException extends Exception {

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

class TransactionService {

    public void processTransaction(
            String transactionId,
            double amount
    ) throws TransactionException {

        try {

            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Transaction amount must be positive"
                );
            }

            if (amount > 50000) {
                throw new IllegalArgumentException(
                        "Transaction limit exceeded"
                );
            }

            System.out.println(
                    "Transaction successful: " + transactionId
            );

        } catch (IllegalArgumentException e) {

            // Rethrow with additional transaction context
            throw new TransactionException(
                    "Transaction failed. ID: " + transactionId
                            + ", Amount: " + amount,
                    e
            );
        }
    }
}

public class TransactionExceptionExample {

    public static void main(String[] args) {

        TransactionService service = new TransactionService();

        try {

            service.processTransaction("TXN101", 75000);

        } catch (TransactionException e) {

            System.out.println(e.getMessage());

            System.out.println(
                    "Reason: " + e.getCause().getMessage()
            );
        }
    }
}