import java.util.ArrayList;
import java.util.List;

public class SmartWarehouseManagement {

    // Parent class for all warehouse items
    static abstract class WarehouseItem {
        private String name;
        private double price;

        WarehouseItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        String getName() {
            return name;
        }

        double getPrice() {
            return price;
        }

        abstract String getCategory();

        @Override
        public String toString() {
            return name + " | " + getCategory()
                    + " | Rs. " + price;
        }
    }

    static class Electronics extends WarehouseItem {
        Electronics(String name, double price) {
            super(name, price);
        }

        @Override
        String getCategory() {
            return "Electronics";
        }
    }

    static class Groceries extends WarehouseItem {
        Groceries(String name, double price) {
            super(name, price);
        }

        @Override
        String getCategory() {
            return "Groceries";
        }
    }

    static class Furniture extends WarehouseItem {
        Furniture(String name, double price) {
            super(name, price);
        }

        @Override
        String getCategory() {
            return "Furniture";
        }
    }

    // Generic storage accepts only WarehouseItem subclasses
    static class Storage<T extends WarehouseItem> {
        private final List<T> items = new ArrayList<>();

        void addItem(T item) {
            items.add(item);
        }

        T getItem(int index) {
            return items.get(index);
        }

        List<T> getItems() {
            return items;
        }

        void displayItems() {
            displayAll(items);
        }
    }

    // Wildcard method accepts lists of any WarehouseItem subtype
    static void displayAll(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(
                new Electronics("Laptop", 55000));

        electronicsStorage.addItem(
                new Electronics("Mobile", 25000));

        groceryStorage.addItem(
                new Groceries("Rice", 1200));

        groceryStorage.addItem(
                new Groceries("Wheat", 800));

        furnitureStorage.addItem(
                new Furniture("Office Chair", 5000));

        furnitureStorage.addItem(
                new Furniture("Table", 8000));

        System.out.println("--- Electronics ---");
        electronicsStorage.displayItems();

        System.out.println("\n--- Groceries ---");
        groceryStorage.displayItems();

        System.out.println("\n--- Furniture ---");
        furnitureStorage.displayItems();

        // Combine items from different storage types
        List<WarehouseItem> allItems = new ArrayList<>();

        allItems.addAll(electronicsStorage.getItems());
        allItems.addAll(groceryStorage.getItems());
        allItems.addAll(furnitureStorage.getItems());

        System.out.println("\n--- All Warehouse Items ---");
        displayAll(allItems);
    }
}