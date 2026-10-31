package DesignPattern.behavioral;

public class VisitorPattern {

    interface Item {
        void accept(Visitor visitor);
    }

    interface Visitor {
        void visit(Book book);

        void visit(Electronics electronics);
    }

    static class Book implements Item {

        private final double price;

        public Book(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class Electronics implements Item {

        private final double price;

        public Electronics(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class PriceCalculatorVisitor implements Visitor {

        private double totalPrice;

        @Override
        public void visit(Book book) {
            totalPrice += book.getPrice();
            System.out.println("Book price: Rs." + book.getPrice());
        }

        @Override
        public void visit(Electronics electronics) {
            totalPrice += electronics.getPrice();
            System.out.println(
                    "Electronics price: Rs." + electronics.getPrice());
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }

    public static void main(String[] args) {

        Item book = new Book(500);
        Item electronics = new Electronics(15000);

        PriceCalculatorVisitor visitor =
                new PriceCalculatorVisitor();

        book.accept(visitor);
        electronics.accept(visitor);

        System.out.println("Total Price: Rs."
                + visitor.getTotalPrice());
    }
}