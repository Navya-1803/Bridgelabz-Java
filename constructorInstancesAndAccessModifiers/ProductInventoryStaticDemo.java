class InventoryProduct {
    String productName;
    double price;

    // Shared variable: common to every product object
    static int totalProducts = 0;

    InventoryProduct(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method: displays one product's details
    void displayProductDetails() {
        System.out.println("Product: " + productName);
        System.out.println("Price: INR " + price);
    }

    // Class method: displays the total number of products created
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}

public class ProductInventoryStaticDemo {
    public static void main(String[] args) {
        InventoryProduct first = new InventoryProduct("Laptop", 55000);
        InventoryProduct second = new InventoryProduct("Mouse", 800);
        InventoryProduct third = new InventoryProduct("Keyboard", 1500);

        first.displayProductDetails();
        System.out.println();

        second.displayProductDetails();
        System.out.println();

        third.displayProductDetails();
        System.out.println();

        InventoryProduct.displayTotalProducts();
    }
}