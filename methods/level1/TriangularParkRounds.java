package level1;
import java.util.Scanner;

public class TriangularParkRounds {

    // Calculate the number of rounds needed to cover 5 km
    public static double calculateRounds(
            double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double targetDistance = 5000;

        return targetDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first side in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter second side in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter third side in meters: ");
        double side3 = input.nextDouble();

        // Validate that the sides form a triangle
        if (side1 > 0 && side2 > 0 && side3 > 0
                && side1 + side2 > side3
                && side1 + side3 > side2
                && side2 + side3 > side1) {

            double rounds = calculateRounds(side1, side2, side3);

            System.out.printf("Rounds required to cover 5 km: %.2f%n",
                    rounds);

            // Whole rounds required to cover at least 5 km
            System.out.println("Complete rounds required: "
                    + (long) Math.ceil(rounds));
        } else {
            System.out.println("Please enter valid triangle sides.");
        }

        input.close();
    }
}
