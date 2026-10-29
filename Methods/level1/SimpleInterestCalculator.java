package level1;

import java.util.Scanner;

public class SimpleInterestCalculator {

    // Calculate simple interest using principal, rate, and time
    public static double calculateSimpleInterest(
            double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter principal: ");
        double principal = input.nextDouble();

        System.out.print("Enter rate of interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter time in years: ");
        double time = input.nextDouble();

        // Call the method and store the returned interest
        double interest = calculateSimpleInterest(principal, rate, time);

        System.out.printf(
                "The Simple Interest is %.2f for Principal %.2f, "
                        + "Rate of Interest %.2f and Time %.2f years.%n",
                interest, principal, rate, time
        );

        input.close();
    }
}
