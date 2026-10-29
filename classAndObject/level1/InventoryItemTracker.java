package level1;

public class InventoryItemTracker {

    static class Item {
        int itemCode;
        String itemName;
        double price;

        // Initialize item details
        Item(int itemCode, String itemName, double price) {
            this.itemCode = itemCode;
            this.itemName = itemName;
            this.price = price;
        }

        // Calculate the total cost for a quantity
        double calculateTotalCost(int quantity) {
            return price * quantity;
        }

        // Display item details
        void displayDetails() {
            System.out.println("Item Code: " + itemCode);
            System.out.println("Item Name: " + itemName);
            System.out.println("Unit Price: INR " + price);
        }
    }

    public static void main(String[] args) {
        Item item = new Item(501, "Notebook", 60.00);
        int quantity = 5;

        item.displayDetails();

        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: INR "
                + item.calculateTotalCost(quantity));
    }
}
