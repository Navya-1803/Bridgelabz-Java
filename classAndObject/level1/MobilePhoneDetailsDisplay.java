package level1;

public class MobilePhoneDetailsDisplay {

    static class MobilePhone {
        String brand;
        String model;
        double price;

        // Initialize phone details
        MobilePhone(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        // Display all phone details
        void displayDetails() {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Price: INR " + price);
        }
    }

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone(
                "Samsung", "Galaxy S Series", 55000.00);

        phone.displayDetails();
    }
}
