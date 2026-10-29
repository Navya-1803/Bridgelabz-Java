package level2;

import java.util.Scanner;

public class DistanceUnitUtility {

    // Convert kilometers to miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // Convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // Convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // Convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter kilometers: ");
        double km = input.nextDouble();
        System.out.printf("Miles: %.4f%n", convertKmToMiles(km));

        System.out.print("Enter miles: ");
        double miles = input.nextDouble();
        System.out.printf("Kilometers: %.4f%n", convertMilesToKm(miles));

        System.out.print("Enter meters: ");
        double meters = input.nextDouble();
        System.out.printf("Feet: %.4f%n", convertMetersToFeet(meters));

        System.out.print("Enter feet: ");
        double feet = input.nextDouble();
        System.out.printf("Meters: %.4f%n", convertFeetToMeters(feet));

        input.close();
    }
}
