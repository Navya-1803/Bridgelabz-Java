package DesignPattern.behavioral;

public class TemplateMethodPattern {

    abstract static class OrderProcess {

        public final void processOrder() {

            selectProduct();
            makePayment();
            deliverOrder();

            System.out.println("Order completed");
        }

        protected abstract void selectProduct();

        protected abstract void makePayment();

        protected abstract void deliverOrder();
    }

    static class OnlineOrder extends OrderProcess {

        @Override
        protected void selectProduct() {
            System.out.println("Product selected online");
        }

        @Override
        protected void makePayment() {
            System.out.println("Payment completed online");
        }

        @Override
        protected void deliverOrder() {
            System.out.println("Product delivered to address");
        }
    }

    static class StoreOrder extends OrderProcess {

        @Override
        protected void selectProduct() {
            System.out.println("Product selected in store");
        }

        @Override
        protected void makePayment() {
            System.out.println("Payment completed at store");
        }

        @Override
        protected void deliverOrder() {
            System.out.println("Product handed over to customer");
        }
    }

    public static void main(String[] args) {

        System.out.println("Online Order:");

        OrderProcess onlineOrder = new OnlineOrder();
        onlineOrder.processOrder();

        System.out.println("\nStore Order:");

        OrderProcess storeOrder = new StoreOrder();
        storeOrder.processOrder();
    }
}