public class BankAccountHierarchy {

    static class AccountRecord {
        protected String accountNumber;
        protected double balance;

        AccountRecord(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        void displayAccountType() {
            System.out.println("General Bank Account");
        }

        void displayDetails() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
            displayAccountType();
        }
    }

    static class SavingsAccount extends AccountRecord {
        private double interestRate;

        SavingsAccount(String accountNumber, double balance,
                       double interestRate) {
            super(accountNumber, balance);
            this.interestRate = interestRate;
        }

        @Override
        void displayAccountType() {
            System.out.println("Account Type: Savings Account");
            System.out.println("Interest Rate: " + interestRate + "%");
        }
    }

    static class CheckingAccount extends AccountRecord {
        private double withdrawalLimit;

        CheckingAccount(String accountNumber, double balance,
                        double withdrawalLimit) {
            super(accountNumber, balance);
            this.withdrawalLimit = withdrawalLimit;
        }

        @Override
        void displayAccountType() {
            System.out.println("Account Type: Checking Account");
            System.out.println("Withdrawal Limit: " + withdrawalLimit);
        }
    }

    static class FixedDepositAccount extends AccountRecord {
        private int depositPeriodMonths;

        FixedDepositAccount(String accountNumber, double balance,
                            int depositPeriodMonths) {
            super(accountNumber, balance);
            this.depositPeriodMonths = depositPeriodMonths;
        }

        @Override
        void displayAccountType() {
            System.out.println("Account Type: Fixed Deposit");
            System.out.println("Deposit Period: "
                    + depositPeriodMonths + " months");
        }
    }

    public static void main(String[] args) {
        AccountRecord[] accounts = {
                new SavingsAccount("SA101", 25000, 4.5),
                new CheckingAccount("CA102", 15000, 5000),
                new FixedDepositAccount("FD103", 100000, 12)
        };

        for (AccountRecord account : accounts) {
            account.displayDetails();
            System.out.println("-------------------");
        }
    }
}