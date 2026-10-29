public class ShoppingCartSystemDemo {

    static class CartProductRecord {
        static double discount = 10.0; // Discount percentage

        private String productName;
        private double price;
        private int quantity;
        private final int productID;

        CartProductRecord(
                String productName, double price,
                int quantity, int productID) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
            this.productID = productID;
        }

        static void updateDiscount(double newDiscount) {
            if (newDiscount >= 0 && newDiscount <= 100) {
                discount = newDiscount;
            } else {
                System.out.println("Invalid discount percentage.");
            }
        }

        void displayDetails() {
            double total = price * quantity;
            double finalPrice = total - (total * discount / 100);

            System.out.println("Product: " + productName);
            System.out.println("Product ID: " + productID);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Final Price: " + finalPrice);
        }
    }

    public static void main(String[] args) {
        CartProductRecord product =
                new CartProductRecord("Keyboard", 1500, 2, 501);

        CartProductRecord.updateDiscount(15);

        Object item = product;

        if (item instanceof CartProductRecord) {
            ((CartProductRecord) item).displayDetails();
        }
    }
}