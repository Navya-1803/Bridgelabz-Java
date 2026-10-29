package level1;

import java.util.Scanner;

public class KilometersToMilesInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();

        // Convert kilometers to miles using the given factor
        double miles = km / 1.6;

        System.out.printf(
                "The total miles is %.2f mile for the given %.2f km%n",
                miles, km
        );

        input.close();
    }
}
