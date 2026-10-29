import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {

    interface Taxable {
        double calculateTax();
        String getTaxDetails();
    }

    static abstract class Product {
        private int productId;
        private String name;
        private double price;

        Product(int productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            setPrice(price);
        }

        abstract double calculateDiscount();

        public int getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            if (price >= 0) {
                this.price = price;
            }
        }

        double calculateFinalPrice() {
            double tax = (this instanceof Taxable)
                    ? ((Taxable) this).calculateTax() : 0;
            return price + tax - calculateDiscount();
        }

        void displayPriceDetails() {
            System.out.println("Product: " + name);
            System.out.println("Original Price: " + price);
            System.out.println("Discount: " + calculateDiscount());

            if (this instanceof Taxable) {
                Taxable taxable = (Taxable) this;
                System.out.println(taxable.getTaxDetails());
            }

            System.out.println("Final Price: " + calculateFinalPrice());
        }
    }

    static class Electronics extends Product implements Taxable {
        Electronics(int id, String name, double price) {
            super(id, name, price);
        }

        @Override
        double calculateDiscount() {
            return getPrice() * 0.10;
        }

        @Override
        public double calculateTax() {
            return getPrice() * 0.18;
        }

        @Override
        public String getTaxDetails() {
            return "Electronics tax: 18%";
        }
    }

    static class Clothing extends Product implements Taxable {
        Clothing(int id, String name, double price) {
            super(id, name, price);
        }

        @Override
        double calculateDiscount() {
            return getPrice() * 0.15;
        }

        @Override
        public double calculateTax() {
            return getPrice() * 0.05;
        }

        @Override
        public String getTaxDetails() {
            return "Clothing tax: 5% (example rate)";
        }
    }

    static class Groceries extends Product {
        Groceries(int id, String name, double price) {
            super(id, name, price);
        }

        @Override
        double calculateDiscount() {
            return getPrice() * 0.02;
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Headphones", 2000));
        products.add(new Clothing(2, "Jacket", 3000));
        products.add(new Groceries(3, "Rice", 1000));

        for (Product product : products) {
            product.displayPriceDetails();
            System.out.println("-------------------");
        }
    }
}