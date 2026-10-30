import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCartSystem {

    private final Map<String, Double> productPrices = new HashMap<>();

    private final Map<String, Integer> cart = new LinkedHashMap<>();

    void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }

        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    void displayCartInInsertionOrder() {
        System.out.println("\nCart in insertion order:");

        cart.forEach((product, quantity) ->
                System.out.println(product + " x " + quantity));
    }

    void displayProductsSortedByPrice() {
        // TreeMap uses price as key and product name as value.
        // Lists handle products having equal prices.
        TreeMap<Double, java.util.List<String>> sorted =
                new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = productPrices.get(product);

            sorted.computeIfAbsent(
                    price,
                    key -> new java.util.ArrayList<>()
            ).add(product);
        }

        System.out.println("\nCart sorted by product price:");

        sorted.forEach((price, products) -> {
            for (String product : products) {
                System.out.println(product + " - Rs. " + price);
            }
        });
    }

    void displayTotal() {
        double total = 0;

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            double price = productPrices.get(entry.getKey());
            total += price * entry.getValue();
        }

        System.out.println("\nTotal cart amount: Rs. " + total);
    }

    public static void main(String[] args) {
        ShoppingCartSystem shoppingCart = new ShoppingCartSystem();

        shoppingCart.addProduct("Laptop", 55000);
        shoppingCart.addProduct("Mouse", 500);
        shoppingCart.addProduct("Keyboard", 1500);
        shoppingCart.addProduct("Monitor", 12000);

        shoppingCart.addToCart("Laptop", 1);
        shoppingCart.addToCart("Mouse", 2);
        shoppingCart.addToCart("Keyboard", 1);
        shoppingCart.addToCart("Monitor", 1);

        shoppingCart.displayCartInInsertionOrder();
        shoppingCart.displayProductsSortedByPrice();
        shoppingCart.displayTotal();
    }
}