package level1;

import java.util.Scanner;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter base in inches: ");
        double base = input.nextDouble();

        System.out.print("Enter height in inches: ");
        double height = input.nextDouble();

        // Calculate the area in square inches
        double areaSquareInches = 0.5 * base * height;

        // Convert square inches to square centimeters
        double areaSquareCm = areaSquareInches * 6.4516;

        System.out.printf("Area in square inches: %.2f%n",
                areaSquareInches);
        System.out.printf("Area in square centimeters: %.2f%n",
                areaSquareCm);

        input.close();
    }
}
