package level1;

import java.util.Scanner;

public class TrigonometricCalculator {

    // Return sine, cosine, and tangent of an angle in degrees
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Java's Math trigonometric functions require radians
        double radians = Math.toRadians(angle);

        // Calculate the three trigonometric values
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        // Return results in the order: sine, cosine, tangent
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an angle in degrees: ");
        double angle = input.nextDouble();

        // Call the method and retrieve the results
        double[] result = calculateTrigonometricFunctions(angle);

        System.out.printf("Sine of %.2f degrees: %.4f%n",
                angle, result[0]);
        System.out.printf("Cosine of %.2f degrees: %.4f%n",
                angle, result[1]);

        // Tangent is mathematically undefined when cosine is zero
        if (Math.abs(Math.cos(Math.toRadians(angle))) < 1e-10) {
            System.out.println("Tangent is undefined for this angle.");
        } else {
            System.out.printf("Tangent of %.2f degrees: %.4f%n",
                    angle, result[2]);
        }

        input.close();
    }
}
