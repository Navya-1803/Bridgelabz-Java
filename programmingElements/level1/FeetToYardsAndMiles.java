package level1;

import java.util.Scanner;

public class FeetToYardsAndMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();

        // Convert feet to yards
        double distanceInYards = distanceInFeet / 3;

        // Convert yards to miles
        double distanceInMiles = distanceInYards / 1760;

        System.out.printf("Distance in yards: %.2f%n",
                distanceInYards);
        System.out.printf("Distance in miles: %.4f%n",
                distanceInMiles);

        input.close();
    }
}
