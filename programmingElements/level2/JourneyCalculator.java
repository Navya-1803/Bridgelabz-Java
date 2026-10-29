package level2;

import java.util.Scanner;

public class JourneyCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter starting city: ");
        String fromCity = input.nextLine();

        System.out.print("Enter intermediate city: ");
        String viaCity = input.nextLine();

        System.out.print("Enter destination city: ");
        String toCity = input.nextLine();

        System.out.print("Enter distance from starting to intermediate city (miles): ");
        double fromToVia = input.nextDouble();

        System.out.print("Enter distance from intermediate to destination (miles): ");
        double viaToFinalCity = input.nextDouble();

        System.out.print("Enter total journey time (hours): ");
        double timeTaken = input.nextDouble();

        // Calculate total distance
        double totalDistance = fromToVia + viaToFinalCity;

        System.out.println("\n--- Journey Details ---");
        System.out.println("Traveler: " + name);
        System.out.println("Route: " + fromCity + " -> "
                + viaCity + " -> " + toCity);
        System.out.printf("Total distance: %.2f miles%n", totalDistance);

        // Calculate average speed if journey time is positive
        if (timeTaken > 0) {
            double averageSpeed = totalDistance / timeTaken;
            System.out.printf("Average speed: %.2f miles/hour%n",
                    averageSpeed);
        } else {
            System.out.println("Journey time must be greater than zero.");
        }

        input.close();
    }
}
