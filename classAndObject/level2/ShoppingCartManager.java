package level2;

public class ShoppingCartManager {

    static class CartItem {
        String itemName;
        double price;
        int quantity;

        // Initialize a cart item
        CartItem(String itemName, double price, int quantity) {
            if (price < 0 || quantity < 0) {
                throw new IllegalArgumentException(
                        "Price and quantity cannot be negative.");
            }

            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        // Add units to the cart item
        void addItem(int quantityToAdd) {
            if (quantityToAdd <= 0) {
                System.out.println("Quantity to add must be positive.");
                return;
            }

            quantity += quantityToAdd;
            System.out.println(quantityToAdd + " units added.");
        }

        // Remove units from the cart item
        void removeItem(int quantityToRemove) {
            if (quantityToRemove <= 0) {
                System.out.println("Quantity to remove must be positive.");
            } else if (quantityToRemove > quantity) {
                System.out.println("Cannot remove more items than available.");
            } else {
                quantity -= quantityToRemove;
                System.out.println(quantityToRemove + " units removed.");
            }
        }

        // Calculate the total cost
        double calculateTotalCost() {
            return price * quantity;
        }

        // Display the current cart item and total
        void displayCart() {
            System.out.println("Item Name: " + itemName);
            System.out.printf("Unit Price: INR %.2f%n", price);
            System.out.println("Quantity: " + quantity);
            System.out.printf("Total Cost: INR %.2f%n",
                    calculateTotalCost());
        }
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Wireless Mouse", 800.00, 2);

        System.out.println("Initial Cart:");
        item.displayCart();

        System.out.println("\nAdding an item:");
        item.addItem(1);

        System.out.println("\nRemoving an item:");
        item.removeItem(1);

        System.out.println("\nUpdated Cart:");
        item.displayCart();
    }
}
