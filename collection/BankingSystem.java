import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BankingSystem {

    private final Map<Integer, Double> accounts = new HashMap<>();

    private final Queue<WithdrawalRequest> requests =
            new LinkedList<>();

    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    void requestWithdrawal(int accountNumber, double amount) {
        requests.add(new WithdrawalRequest(accountNumber, amount));
    }

    void processWithdrawals() {
        while (!requests.isEmpty()) {
            WithdrawalRequest request = requests.remove();

            int accountNumber = request.accountNumber;
            double amount = request.amount;

            if (!accounts.containsKey(accountNumber)) {
                System.out.println(
                        "Account not found: " + accountNumber);
                continue;
            }

            double balance = accounts.get(accountNumber);

            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
            } else if (balance >= amount) {
                accounts.put(accountNumber, balance - amount);

                System.out.println(
                        "Withdrawal of Rs. " + amount
                                + " successful for account "
                                + accountNumber);
            } else {
                System.out.println(
                        "Insufficient balance for account "
                                + accountNumber);
            }
        }
    }

    void displayAccountsSortedByBalance() {
        // TreeMap uses balance as key.
        // A list allows multiple accounts with the same balance.
        TreeMap<Double, java.util.List<Integer>> sortedAccounts =
                new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.computeIfAbsent(
                    entry.getValue(),
                    key -> new java.util.ArrayList<>()
            ).add(entry.getKey());
        }

        System.out.println("\nAccounts sorted by balance:");

        sortedAccounts.forEach((balance, accountNumbers) -> {
            for (int accountNumber : accountNumbers) {
                System.out.println(
                        "Account: " + accountNumber
                                + ", Balance: Rs. " + balance);
            }
        });
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount(1001, 50000);
        bank.createAccount(1002, 30000);
        bank.createAccount(1003, 75000);

        // Withdrawal requests are processed in FIFO order
        bank.requestWithdrawal(1001, 10000);
        bank.requestWithdrawal(1002, 35000);
        bank.requestWithdrawal(1003, 15000);

        System.out.println("Processing withdrawals:");
        bank.processWithdrawals();

        bank.displayAccountsSortedByBalance();
    }
}