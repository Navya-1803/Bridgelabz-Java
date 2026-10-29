public class BankAccountSystemDemo {

    static class BankAccountRecord {
        static String bankName = "State Bank of India";
        private static int totalAccounts = 0;

        private String accountHolderName;

        // final variable can be assigned only once
        private final long accountNumber;

        BankAccountRecord(String accountHolderName, long accountNumber) {
            // this distinguishes instance variables from parameters
            this.accountHolderName = accountHolderName;
            this.accountNumber = accountNumber;
            totalAccounts++;
        }

        static int getTotalAccounts() {
            return totalAccounts;
        }

        void displayDetails() {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }
    }

    public static void main(String[] args) {
        BankAccountRecord account1 =
                new BankAccountRecord("Aarav", 10001);
        BankAccountRecord account2 =
                new BankAccountRecord("Priya", 10002);

        // instanceof verifies the object's type
        Object account = account1;

        if (account instanceof BankAccountRecord) {
            ((BankAccountRecord) account).displayDetails();
        }

        System.out.println("Total Accounts: "
                + BankAccountRecord.getTotalAccounts());
    }
}