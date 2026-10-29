package level1;

public class UniversityFeeDiscount {
    public static void main(String[] args) {
        double fee = 125000.0;
        double discountPercent = 10.0;

        // Calculate the discount amount
        double discount = fee * discountPercent / 100;

        // Calculate the final fee after discount
        double discountedFee = fee - discount;

        System.out.printf(
                "The discount amount is INR %.2f and final discounted fee is INR %.2f%n",
                discount, discountedFee
        );
    }
}
