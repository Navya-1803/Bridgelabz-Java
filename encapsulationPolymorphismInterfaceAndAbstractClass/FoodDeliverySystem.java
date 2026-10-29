import java.util.ArrayList;
import java.util.List;

public class FoodDeliverySystem {

    interface Discountable {
        double applyDiscount(double percentage);
        String getDiscountDetails();
    }

    static abstract class FoodItem implements Discountable {
        private String itemName;
        private double price;
        private int quantity;

        FoodItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            setPrice(price);
            setQuantity(quantity);
        }

        abstract double calculateTotalPrice();

        public String getItemName() {
            return itemName;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setPrice(double price) {
            if (price >= 0) {
                this.price = price;
            }
        }

        public void setQuantity(int quantity) {
            if (quantity >= 0) {
                this.quantity = quantity;
            }
        }

        void getItemDetails() {
            System.out.println("Item: " + itemName);
            System.out.println("Unit Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total: " + calculateTotalPrice());
        }

        @Override
        public double applyDiscount(double percentage) {
            if (percentage < 0 || percentage > 100) {
                return calculateTotalPrice();
            }

            return calculateTotalPrice()
                    * (1 - percentage / 100);
        }

        @Override
        public String getDiscountDetails() {
            return "Discount is calculated on the item total.";
        }
    }

    static class VegItem extends FoodItem {
        VegItem(String name, double price, int quantity) {
            super(name, price, quantity);
        }

        @Override
        double calculateTotalPrice() {
            return getPrice() * getQuantity();
        }
    }

    static class NonVegItem extends FoodItem {
        private double additionalCharge;

        NonVegItem(String name, double price, int quantity,
                   double additionalCharge) {
            super(name, price, quantity);
            this.additionalCharge = Math.max(0, additionalCharge);
        }

        @Override
        double calculateTotalPrice() {
            return (getPrice() + additionalCharge) * getQuantity();
        }
    }

    static void processOrder(List<FoodItem> items) {
        double orderTotal = 0;

        for (FoodItem item : items) {
            item.getItemDetails();
            System.out.println("Price after 10% discount: "
                    + item.applyDiscount(10));
            System.out.println(item.getDiscountDetails());
            orderTotal += item.calculateTotalPrice();
            System.out.println("-------------------");
        }

        System.out.println("Order Total Before Discounts: " + orderTotal);
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Wrap", 150, 2));
        order.add(new NonVegItem("Chicken Burger", 220, 2, 30));

        processOrder(order);
    }
}