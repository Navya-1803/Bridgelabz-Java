package DesignPattern.structural;

public class FacadePattern {

    static class AccountService {

        public void verifyAccount() {
            System.out.println("Account verified");
        }
    }

    static class BalanceService {

        public void checkBalance() {
            System.out.println("Balance checked");
        }
    }

    static class TransactionService {

        public void transferMoney() {
            System.out.println("Money transferred successfully");
        }
    }

    static class BankFacade {

        private final AccountService accountService;
        private final BalanceService balanceService;
        private final TransactionService transactionService;

        public BankFacade() {
            accountService = new AccountService();
            balanceService = new BalanceService();
            transactionService = new TransactionService();
        }

        public void transfer() {

            accountService.verifyAccount();
            balanceService.checkBalance();
            transactionService.transferMoney();
        }
    }

    public static void main(String[] args) {

        BankFacade bank = new BankFacade();

        bank.transfer();
    }
}