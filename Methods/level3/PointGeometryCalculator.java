package level3;

import java.util.Scanner;

public class PointGeometryCalculator {

    // Calculate Euclidean distance between two points
    public static double calculateDistance(
            double x1, double y1, double x2, double y2) {

        double deltaX = x2 - x1;
        double deltaY = y2 - y1;

        return Math.sqrt(
                Math.pow(deltaX, 2) + Math.pow(deltaY, 2)
        );
    }

    // Return slope and y-intercept in an array
    public static double[] calculateLineEquation(
            double x1, double y1, double x2, double y2) {

        if (x1 == x2) {
            throw new IllegalArgumentException(
                    "The line is vertical; its equation is x = " + x1);
        }

        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;

        return new double[]{slope, intercept};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = input.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = input.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = input.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = input.nextDouble();

        double distance = calculateDistance(x1, y1, x2, y2);

        System.out.printf("Euclidean distance: %.2f%n", distance);

        try {
            double[] line = calculateLineEquation(x1, y1, x2, y2);

            System.out.printf("Slope (m): %.2f%n", line[0]);
            System.out.printf("Y-intercept (b): %.2f%n", line[1]);
            System.out.printf("Line equation: y = %.2fx + %.2f%n",
                    line[0], line[1]);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}
