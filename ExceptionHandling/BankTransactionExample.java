import java.util.Scanner;

// Custom checked exception
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank account class
class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance!"
            );
        }

        balance -= amount;

        System.out.println(
                "Withdrawal successful, new balance: " + balance
        );
    }
}

public class BankTransactionExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(10000);

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}