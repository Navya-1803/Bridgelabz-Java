package level2;

import java.util.Scanner;

public class QuadraticEquationSolver {

    // Return two roots, one root, or an empty array for no real roots
    public static double[] findRoots(double a, double b, double c) {
        // If a is zero, the equation is not quadratic
        if (a == 0) {
            throw new IllegalArgumentException(
                    "Coefficient a must not be zero.");
        }

        // Calculate the discriminant using Math.pow()
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) {
            // Two distinct real roots
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);

            return new double[]{root1, root2};
        } else if (delta == 0) {
            // One repeated real root
            double root = -b / (2 * a);

            return new double[]{root};
        } else {
            // Negative discriminant means no real roots
            return new double[0];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = input.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = input.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = input.nextDouble();

        try {
            // Calculate the roots using the method
            double[] roots = findRoots(a, b, c);

            if (roots.length == 0) {
                System.out.println("No real roots exist.");
            } else if (roots.length == 1) {
                System.out.println("Repeated root: " + roots[0]);
            } else {
                System.out.println("Root 1: " + roots[0]);
                System.out.println("Root 2: " + roots[1]);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}
