import java.util.Scanner;

class StudentGrade {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of students
        int students = sc.nextInt();

        // 2D array to store marks of Physics, Chemistry, and Maths
        int[][] marks = new int[students][3];   // 0-Physics, 1-Chemistry, 2-Maths

        // Array to store percentage of each student
        double[] percentage = new double[students];

        // Array to store grade of each student
        char[] grade = new char[students];

        // Read marks for each student with validation
        for (int i = 0; i < students; i++) {
            System.out.println("Enter marks for student " + (i + 1));

            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();

            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();

            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();

            // Validate marks
            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Invalid marks. Enter positive values again.");
                i--; // re-enter same student
            }
        }

        // Calculate percentage and assign grades
        for (int i = 0; i < students; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) {
                grade[i] = 'A';
            } else if (percentage[i] >= 75) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 40) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }

        // Display marks, percentage, and grade of each student
        for (int i = 0; i < students; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }
    }
}