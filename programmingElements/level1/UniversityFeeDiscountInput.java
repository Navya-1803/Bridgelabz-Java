package level1;

import java.util.Scanner;

public class UniversityFeeDiscountInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student fee: ");
        double fee = input.nextDouble();

        System.out.print("Enter discount percentage: ");
        double discountPercent = input.nextDouble();

        // Calculate the discount and final fee
        double discount = fee * discountPercent / 100;
        double discountedFee = fee - discount;

        System.out.printf(
                "The discount amount is INR %.2f and "
                        + "final discounted fee is INR %.2f%n",
                discount, discountedFee
        );

        input.close();
    }
}
