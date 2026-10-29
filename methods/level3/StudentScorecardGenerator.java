package level3;

import java.util.Scanner;

public class StudentScorecardGenerator {

    private static final int SUBJECT_COUNT = 3;
    private static final int MAX_MARKS_PER_SUBJECT = 100;

    // Generate random two-digit marks from 10 to 99
    public static int[][] generateMarks(int numberOfStudents) {
        int[][] marks = new int[numberOfStudents][SUBJECT_COUNT];

        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < SUBJECT_COUNT; j++) {
                marks[i][j] = (int) (Math.random() * 90) + 10;
            }
        }

        return marks;
    }

    // Round a number to two decimal places
    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // Calculate total, average, and percentage for every student.
    // Result columns: total, average, percentage.
    public static double[][] calculateResults(int[][] marks) {
        double[][] results = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {
            int total = 0;

            for (int j = 0; j < SUBJECT_COUNT; j++) {
                total += marks[i][j];
            }

            double average = (double) total / SUBJECT_COUNT;
            double percentage = (double) total
                    / (SUBJECT_COUNT * MAX_MARKS_PER_SUBJECT) * 100;

            results[i][0] = total;
            results[i][1] = roundToTwoDecimals(average);
            results[i][2] = roundToTwoDecimals(percentage);
        }

        return results;
    }

    // Assign grades using the table provided in the PDF
    public static String getGrade(double percentage) {
        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "R";
        }
    }

    // Display the complete scorecard
    public static void displayScorecard(
            int[][] marks, double[][] results) {

        System.out.println("\nStudent Scorecard");
        System.out.println(
                "Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");

        for (int i = 0; i < marks.length; i++) {
            System.out.printf(
                    "%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\t\t%s%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    getGrade(results[i][2])
            );
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        if (numberOfStudents <= 0) {
            System.out.println("Number of students must be positive.");
            input.close();
            return;
        }

        int[][] marks = generateMarks(numberOfStudents);
        double[][] results = calculateResults(marks);

        displayScorecard(marks, results);

        input.close();
    }
}
