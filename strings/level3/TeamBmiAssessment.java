package level3;

import java.util.Scanner;

public class TeamBmiAssessment {

    private static final int TEAM_SIZE = 10;

    // Determine BMI status using common adult BMI categories
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }

    // Calculate BMI and return height, weight, BMI, and status
    public static String[] calculateBmi(double weight, double heightCm) {
        double heightMeters = heightCm / 100.0;
        double bmi = weight / (heightMeters * heightMeters);

        return new String[]{
                String.format("%.2f", heightCm),
                String.format("%.2f", weight),
                String.format("%.2f", bmi),
                getBmiStatus(bmi)
        };
    }

    // Process all team members and create a 2D result array
    // Input columns: weight in kg, height in cm
    public static String[][] processTeam(double[][] teamData) {
        String[][] results = new String[teamData.length][4];

        for (int i = 0; i < teamData.length; i++) {
            double weight = teamData[i][0];
            double heightCm = teamData[i][1];

            results[i] = calculateBmi(weight, heightCm);
        }

        return results;
    }

    // Display the BMI report
    public static void displayReport(String[][] results) {
        System.out.printf("%-10s %-15s %-15s %-12s %-15s%n",
                "Person", "Height (cm)", "Weight (kg)", "BMI", "Status");

        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < results.length; i++) {
            System.out.printf("%-10d %-15s %-15s %-12s %-15s%n",
                    i + 1,
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    results[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Column 0 = weight in kg; column 1 = height in cm
        double[][] teamData = new double[TEAM_SIZE][2];

        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight in kg: ");
            teamData[i][0] = input.nextDouble();

            System.out.print("Enter height in cm: ");
            teamData[i][1] = input.nextDouble();

            // Validate inputs before calculating BMI
            if (teamData[i][0] <= 0 || teamData[i][1] <= 0) {
                System.out.println("Weight and height must be positive.");
                input.close();
                return;
            }
        }

        String[][] results = processTeam(teamData);
        displayReport(results);

        input.close();
    }
}
