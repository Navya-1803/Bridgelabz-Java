package DesignPattern.behavioral;

public class StrategyPattern {

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CashPayment implements PaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using Cash");
        }
    }

    static class CardPayment implements PaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using Card");
        }
    }

    static class UPIPayment implements PaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using UPI");
        }
    }

    static class PaymentContext {

        private PaymentStrategy strategy;

        public void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void executePayment(double amount) {

            if (strategy == null) {
                throw new IllegalStateException(
                        "Payment strategy not selected");
            }

            strategy.pay(amount);
        }
    }

    public static void main(String[] args) {

        PaymentContext payment = new PaymentContext();

        payment.setStrategy(new CashPayment());
        payment.executePayment(500);

        payment.setStrategy(new CardPayment());
        payment.executePayment(1000);

        payment.setStrategy(new UPIPayment());
        payment.executePayment(750);
    }
}