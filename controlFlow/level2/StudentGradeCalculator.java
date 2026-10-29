package level2;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read marks for the three subjects, each out of 100
        System.out.print("Enter Physics marks: ");
        double physics = input.nextDouble();

        System.out.print("Enter Chemistry marks: ");
        double chemistry = input.nextDouble();

        System.out.print("Enter Maths marks: ");
        double maths = input.nextDouble();

        // Validate marks
        if (physics < 0 || physics > 100
                || chemistry < 0 || chemistry > 100
                || maths < 0 || maths > 100) {
            System.out.println("Marks must be between 0 and 100.");
            input.close();
            return;
        }

        // Calculate average percentage
        double average = (physics + chemistry + maths) / 3.0;

        String grade;
        String remarks;

        // Assign grade and remarks based on the PDF grading table
        if (average >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Level 2, below but approaching agency-normalized standards";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        } else if (average >= 40) {
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        // Display average, grade, and remarks
        System.out.printf("Average Percentage: %.2f%%%n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        input.close();
    }
}
