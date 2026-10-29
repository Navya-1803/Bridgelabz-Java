class ManagedBankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    ManagedBankAccount(String accountNumber, String accountHolder,
                       double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        setBalance(balance);
    }

    // Getter for private balance
    public double getBalance() {
        return balance;
    }

    // Setter with basic validation
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }
}

// Subclass demonstrates inherited member access
class SavingsAccount extends ManagedBankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder,
                   double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displaySavingsAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: INR " + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class BankAccountAccessDemo {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount(
                "ACC101", "Aarav", 25000, 4.5);

        account.displaySavingsAccount();

        // Modify private balance through the public setter
        account.setBalance(30000);

        System.out.println("Updated Balance: INR " + account.getBalance());
    }
}