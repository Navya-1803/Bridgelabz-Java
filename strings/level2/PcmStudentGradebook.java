package level2;

import java.util.Scanner;

public class PcmStudentGradebook {

    private static final int SUBJECT_COUNT = 3;
    private static final int MAX_MARKS = 100;

    // Generate random two-digit marks for each student's PCM subjects
    public static int[][] generateStudentMarks(int numberOfStudents) {
        int[][] marks = new int[numberOfStudents][SUBJECT_COUNT];

        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < SUBJECT_COUNT; j++) {
                // Generate marks from 10 through 99
                marks[i][j] = (int) (Math.random() * 90) + 10;
            }
        }

        return marks;
    }

    // Round a value to two decimal places using Math.round()
    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // Calculate total, average, and percentage for each student
    // Result columns: total, average, percentage
    public static double[][] calculateStudentResults(int[][] marks) {
        double[][] results = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {
            int total = 0;

            for (int j = 0; j < SUBJECT_COUNT; j++) {
                total += marks[i][j];
            }

            double average = (double) total / SUBJECT_COUNT;

            double percentage = (double) total
                    / (SUBJECT_COUNT * MAX_MARKS) * 100;

            results[i][0] = total;
            results[i][1] = roundToTwoDecimals(average);
            results[i][2] = roundToTwoDecimals(percentage);
        }

        return results;
    }

    // Assign the grade according to the supplied grading table
    public static String calculateGrade(double percentage) {
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

    // Return a 2D String array containing each student's grade
    public static String[][] calculateStudentGrades(double[][] results) {
        String[][] grades = new String[results.length][1];

        for (int i = 0; i < results.length; i++) {
            grades[i][0] = calculateGrade(results[i][2]);
        }

        return grades;
    }

    // Display the complete student scorecard
    public static void displayScorecard(
            int[][] marks,
            double[][] results,
            String[][] grades) {

        System.out.printf(
                "%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Maths",
                "Total", "Average", "Percentage", "Grade");

        System.out.println(
                "--------------------------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.printf(
                    "%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-11.2f%% %-8s%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    grades[i][0]);
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

        // Generate marks for all students
        int[][] marks = generateStudentMarks(numberOfStudents);

        // Calculate total, average, and percentage
        double[][] results = calculateStudentResults(marks);

        // Assign grades based on percentage
        String[][] grades = calculateStudentGrades(results);

        // Display the scorecard
        displayScorecard(marks, results, grades);

        input.close();
    }
}
