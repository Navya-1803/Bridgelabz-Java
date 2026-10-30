import java.util.ArrayList;
import java.util.List;

public class DynamicOnlineMarketplace {

    // Parent category
    static abstract class ProductCategory {
        abstract String getCategoryName();
    }

    static class BookCategory extends ProductCategory {
        @Override
        String getCategoryName() {
            return "Books";
        }
    }

    static class ClothingCategory extends ProductCategory {
        @Override
        String getCategoryName() {
            return "Clothing";
        }
    }

    static class GadgetCategory extends ProductCategory {
        @Override
        String getCategoryName() {
            return "Gadgets";
        }
    }

    // Generic product class
    static class Product<T extends ProductCategory> {
        private String name;
        private double price;
        private T category;

        Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        double getPrice() {
            return price;
        }

        void setPrice(double price) {
            this.price = price;
        }

        String getName() {
            return name;
        }

        T getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return name + " | "
                    + category.getCategoryName()
                    + " | Rs. " + price;
        }
    }

    // Generic method with bounded type parameter
    static <T extends ProductCategory> void applyDiscount(
            Product<T> product, double percentage) {

        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException(
                    "Discount must be between 0 and 100");
        }

        double discountedPrice =
                product.getPrice()
                        - (product.getPrice() * percentage / 100);

        product.setPrice(discountedPrice);
    }

    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 800,
                        new BookCategory());

        Product<ClothingCategory> clothing =
                new Product<>("T-Shirt", 1200,
                        new ClothingCategory());

        Product<GadgetCategory> gadget =
                new Product<>("Headphones", 2500,
                        new GadgetCategory());

        List<Product<?>> catalog = new ArrayList<>();

        catalog.add(book);
        catalog.add(clothing);
        catalog.add(gadget);

        System.out.println("--- Original Catalog ---");

        for (Product<?> product : catalog) {
            System.out.println(product);
        }

        applyDiscount(book, 10);
        applyDiscount(clothing, 20);
        applyDiscount(gadget, 15);

        System.out.println("\n--- Catalog After Discounts ---");

        for (Product<?> product : catalog) {
            System.out.println(product);
        }
    }
}