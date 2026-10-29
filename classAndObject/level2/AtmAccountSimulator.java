package level2;

public class AtmAccountSimulator {

    static class BankAccount {
        String accountHolder;
        String accountNumber;
        double balance;

        // Initialize bank account details
        BankAccount(String accountHolder, String accountNumber,
                    double balance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        // Deposit money into the account
        void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Deposit amount must be positive.");
                return;
            }

            balance += amount;
            System.out.println("Deposited: INR " + amount);
        }

        // Withdraw money only when sufficient balance exists
        void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                balance -= amount;
                System.out.println("Withdrawn: INR " + amount);
            }
        }

        // Display the current balance
        void displayBalance() {
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Account Number: " + accountNumber);
            System.out.printf("Current Balance: INR %.2f%n", balance);
        }
    }

    public static void main(String[] args) {
        BankAccount account =
                new BankAccount("Rahul", "ACC1001", 5000.00);

        account.displayBalance();

        account.deposit(2000.00);
        account.withdraw(1500.00);

        System.out.println("\nAfter transactions:");
        account.displayBalance();
    }
}
