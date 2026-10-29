import java.util.ArrayList;
import java.util.List;

public class BankingSystem {

    interface Loanable {
        void applyForLoan(double amount);
        boolean calculateLoanEligibility(double amount);
    }

    static abstract class BankAccount {
        private String accountNumber;
        private String holderName;
        private double balance;

        BankAccount(String accountNumber, String holderName,
                    double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = Math.max(0, balance);
        }

        abstract double calculateInterest();

        public double getBalance() {
            return balance;
        }

        public String getHolderName() {
            return holderName;
        }

        // Deposit only a positive amount.
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Prevent withdrawal beyond the available balance.
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Invalid amount or insufficient balance.");
            }
        }

        void displayDetails() {
            System.out.println("Account: ****"
                    + accountNumber.substring(
                    Math.max(0, accountNumber.length() - 4)));
            System.out.println("Holder: " + holderName);
            System.out.println("Balance: " + balance);
            System.out.println("Calculated Interest: "
                    + calculateInterest());
        }
    }

    static class SavingsAccount extends BankAccount implements Loanable {
        private double interestRate;

        SavingsAccount(String number, String name, double balance,
                       double interestRate) {
            super(number, name, balance);
            this.interestRate = interestRate;
        }

        @Override
        double calculateInterest() {
            return getBalance() * interestRate / 100;
        }

        @Override
        public boolean calculateLoanEligibility(double amount) {
            return amount > 0 && getBalance() >= amount * 0.20;
        }

        @Override
        public void applyForLoan(double amount) {
            System.out.println(calculateLoanEligibility(amount)
                    ? "Loan application eligible for review."
                    : "Not eligible under the example criteria.");
        }
    }

    static class CurrentAccount extends BankAccount implements Loanable {
        CurrentAccount(String number, String name, double balance) {
            super(number, name, balance);
        }

        @Override
        double calculateInterest() {
            // Example: no interest paid on the current-account balance.
            return 0;
        }

        @Override
        public boolean calculateLoanEligibility(double amount) {
            return amount > 0 && getBalance() >= amount * 0.30;
        }

        @Override
        public void applyForLoan(double amount) {
            System.out.println(calculateLoanEligibility(amount)
                    ? "Loan application eligible for review."
                    : "Not eligible under the example criteria.");
        }
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount(
                "1234567890", "Ananya", 50000, 4.0));
        accounts.add(new CurrentAccount(
                "9876543210", "Rahul", 80000));

        for (BankAccount account : accounts) {
            account.displayDetails();
            account.deposit(1000);
            System.out.println("-------------------");
        }

        Loanable applicant = (Loanable) accounts.get(0);
        applicant.applyForLoan(10000);
    }
}