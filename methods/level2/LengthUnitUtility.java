package level2;

import java.util.Scanner;

public class LengthUnitUtility {

    // Convert yards to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Convert feet to yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Convert meters to inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // Convert inches to meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // Convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter yards: ");
        double yards = input.nextDouble();
        System.out.printf("Feet: %.4f%n", convertYardsToFeet(yards));

        System.out.print("Enter feet: ");
        double feet = input.nextDouble();
        System.out.printf("Yards: %.4f%n", convertFeetToYards(feet));

        System.out.print("Enter meters: ");
        double meters = input.nextDouble();
        System.out.printf("Inches: %.4f%n", convertMetersToInches(meters));

        System.out.print("Enter inches to convert to meters: ");
        double inchesToMeters = input.nextDouble();
        System.out.printf("Meters: %.4f%n",
                convertInchesToMeters(inchesToMeters));

        System.out.print("Enter inches to convert to centimeters: ");
        double inchesToCm = input.nextDouble();
        System.out.printf("Centimeters: %.4f%n",
                convertInchesToCentimeters(inchesToCm));

        input.close();
    }
}
