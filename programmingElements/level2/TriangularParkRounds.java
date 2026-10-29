package level2;

import java.util.Scanner;

public class TriangularParkRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first side in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter the second side in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter the third side in meters: ");
        double side3 = input.nextDouble();

        // Calculate the perimeter of the triangular park
        double perimeter = side1 + side2 + side3;

        // Convert the target distance from kilometers to meters
        double targetDistance = 5000;

        if (side1 > 0 && side2 > 0 && side3 > 0
                && side1 + side2 > side3
                && side1 + side3 > side2
                && side2 + side3 > side1) {

            // Calculate rounds needed to complete 5 km
            double rounds = targetDistance / perimeter;

            System.out.printf(
                    "The total number of rounds the athlete will run is %.2f "
                            + "to complete 5 km%n",
                    rounds
            );
        } else {
            System.out.println("Please enter valid triangle side lengths.");
        }

        input.close();
    }
}
