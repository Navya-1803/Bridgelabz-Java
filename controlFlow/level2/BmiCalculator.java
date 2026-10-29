package level2;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in kilograms: ");
        double weight = input.nextDouble();

        System.out.print("Enter height in centimeters: ");
        double heightCm = input.nextDouble();

        // Validate the measurements
        if (weight <= 0 || heightCm <= 0) {
            System.out.println("Weight and height must be positive.");
            input.close();
            return;
        }

        // Convert height from centimeters to meters
        double heightMeters = heightCm / 100.0;

        // Calculate BMI
        double bmi = weight / (heightMeters * heightMeters);

        // Determine the adult BMI category
        String weightStatus;

        if (bmi < 18.5) {
            weightStatus = "Underweight";
        } else if (bmi < 25.0) {
            weightStatus = "Normal weight";
        } else if (bmi < 30.0) {
            weightStatus = "Overweight";
        } else {
            weightStatus = "Obesity";
        }

        System.out.printf("BMI: %.2f%n", bmi);
        System.out.println("Weight status: " + weightStatus);

        input.close();
    }
}
