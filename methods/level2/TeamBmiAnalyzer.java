package level2;

import java.util.Scanner;

public class TeamBmiAnalyzer {

    // Column indexes for the 2D array
    private static final int WEIGHT_COLUMN = 0;
    private static final int HEIGHT_COLUMN = 1;
    private static final int BMI_COLUMN = 2;

    // Calculate and store BMI for every person
    public static void calculateBmi(double[][] people) {
        for (int i = 0; i < people.length; i++) {
            // Convert height from centimeters to meters
            double heightInMeters = people[i][HEIGHT_COLUMN] / 100.0;

            // BMI = weight in kg / height in meters squared
            people[i][BMI_COLUMN] =
                    people[i][WEIGHT_COLUMN]
                            / (heightInMeters * heightInMeters);
        }
    }

    // Return the BMI status for each person
    public static String[] determineBmiStatus(double[][] people) {
        String[] statuses = new String[people.length];

        for (int i = 0; i < people.length; i++) {
            double bmi = people[i][BMI_COLUMN];

            if (bmi < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmi < 25.0) {
                statuses[i] = "Normal weight";
            } else if (bmi < 30.0) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obesity";
            }
        }

        return statuses;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Each row stores weight, height, and calculated BMI
        double[][] people = new double[10][3];

        // Collect weight and height for each team member
        for (int i = 0; i < people.length; i++) {
            System.out.println("Member " + (i + 1));

            System.out.print("Enter weight in kg: ");
            people[i][WEIGHT_COLUMN] = input.nextDouble();

            System.out.print("Enter height in cm: ");
            people[i][HEIGHT_COLUMN] = input.nextDouble();

            if (people[i][WEIGHT_COLUMN] <= 0
                    || people[i][HEIGHT_COLUMN] <= 0) {
                System.out.println("Weight and height must be positive.");
                input.close();
                return;
            }
        }

        // Calculate BMI values and their classifications
        calculateBmi(people);
        String[] statuses = determineBmiStatus(people);

        // Display the results for all team members
        System.out.println("\nTeam BMI Report");
        System.out.printf("%-10s %-12s %-12s %-10s %s%n",
                "Member", "Weight(kg)", "Height(cm)", "BMI", "Status");

        for (int i = 0; i < people.length; i++) {
            System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %s%n",
                    i + 1,
                    people[i][WEIGHT_COLUMN],
                    people[i][HEIGHT_COLUMN],
                    people[i][BMI_COLUMN],
                    statuses[i]);
        }

        input.close();
    }
}
