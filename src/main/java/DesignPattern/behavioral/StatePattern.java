package DesignPattern.behavioral;

public class StatePattern {

    interface State {
        void insertCard(ATMContext context);

        void enterPin(ATMContext context);

        void withdraw(ATMContext context);
    }

    static class NoCardState implements State {

        @Override
        public void insertCard(ATMContext context) {
            System.out.println("Card inserted");
            context.setState(new HasCardState());
        }

        @Override
        public void enterPin(ATMContext context) {
            System.out.println("Please insert your card first");
        }

        @Override
        public void withdraw(ATMContext context) {
            System.out.println("Please insert your card first");
        }
    }

    static class HasCardState implements State {

        @Override
        public void insertCard(ATMContext context) {
            System.out.println("Card already inserted");
        }

        @Override
        public void enterPin(ATMContext context) {
            System.out.println("PIN verified");
            context.setState(new AuthorizedState());
        }

        @Override
        public void withdraw(ATMContext context) {
            System.out.println("Enter PIN before withdrawing");
        }
    }

    static class AuthorizedState implements State {

        @Override
        public void insertCard(ATMContext context) {
            System.out.println("Card already inserted");
        }

        @Override
        public void enterPin(ATMContext context) {
            System.out.println("Already authorized");
        }

        @Override
        public void withdraw(ATMContext context) {
            System.out.println("Withdrawal successful");
            context.setState(new NoCardState());
        }
    }

    static class ATMContext {

        private State state;

        public ATMContext() {
            state = new NoCardState();
        }

        public void setState(State state) {
            this.state = state;
        }

        public void insertCard() {
            state.insertCard(this);
        }

        public void enterPin() {
            state.enterPin(this);
        }

        public void withdraw() {
            state.withdraw(this);
        }
    }

    public static void main(String[] args) {

        ATMContext atm = new ATMContext();

        atm.withdraw();

        atm.insertCard();
        atm.withdraw();

        atm.enterPin();
        atm.withdraw();

        atm.withdraw();
    }
}