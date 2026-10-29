package level3;

import java.util.Scanner;

public class CollinearityAnalyzer {

    // Check collinearity using slope relationships without dividing
    public static boolean areCollinearBySlope(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        // Compare cross-products to avoid division by zero
        double slopeABLeft = (y2 - y1) * (x3 - x2);
        double slopeBCRight = (y3 - y2) * (x2 - x1);

        double slopeACLeft = (y3 - y1) * (x2 - x1);
        double slopeACRight = (y2 - y1) * (x3 - x1);

        double epsilon = 1e-9;

        return Math.abs(slopeABLeft - slopeBCRight) < epsilon
                && Math.abs(slopeACLeft - slopeACRight) < epsilon;
    }

    // Calculate the signed area of the triangle
    public static double calculateTriangleArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        return 0.5 * (
                x1 * (y2 - y3)
                        + x2 * (y3 - y1)
                        + x3 * (y1 - y2)
        );
    }

    // Points are collinear if the triangle area is zero
    public static boolean areCollinearByArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        return Math.abs(calculateTriangleArea(
                x1, y1, x2, y2, x3, y3)) < 1e-9;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter coordinates of point A:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.println("Enter coordinates of point B:");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.println("Enter coordinates of point C:");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        boolean slopeResult = areCollinearBySlope(
                x1, y1, x2, y2, x3, y3);

        boolean areaResult = areCollinearByArea(
                x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear using slope method: " + slopeResult);
        System.out.println("Collinear using area method: " + areaResult);

        input.close();
    }
}
