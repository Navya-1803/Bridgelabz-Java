package level2;

public class StudentReportGenerator {

    static class Student {
        String name;
        int rollNumber;
        double marks;

        // Initialize student details
        Student(String name, int rollNumber, double marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        // Calculate the grade based on marks out of 100
        char calculateGrade() {
            if (marks >= 90) {
                return 'A';
            } else if (marks >= 80) {
                return 'B';
            } else if (marks >= 70) {
                return 'C';
            } else if (marks >= 60) {
                return 'D';
            } else {
                return 'F';
            }
        }

        // Display student details and grade
        void displayReport() {
            System.out.println("Student Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Marks: " + marks);
            System.out.println("Grade: " + calculateGrade());
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Rahul", 101, 85.5);

        student.displayReport();
    }
}
