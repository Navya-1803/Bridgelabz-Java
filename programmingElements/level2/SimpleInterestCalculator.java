package level2;

import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter principal amount in INR: ");
        double principal = input.nextDouble();

        System.out.print("Enter annual rate of interest (%): ");
        double rate = input.nextDouble();

        System.out.print("Enter time in years: ");
        double time = input.nextDouble();

        // Calculate simple interest
        double simpleInterest = (principal * rate * time) / 100;

        System.out.printf(
                "The Simple Interest is INR %.2f for Principal INR %.2f, "
                        + "Rate of Interest %.2f%% and Time %.2f years.%n",
                simpleInterest, principal, rate, time
        );

        input.close();
    }
}
