package level2;

import java.util.Scanner;

public class StudentVoteChecker {

    // Check whether a student is eligible to vote
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }

        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create an array to store the ages of 10 students
        int[] ages = new int[10];

        // Create an object to call the instance method
        StudentVoteChecker checker = new StudentVoteChecker();

        // Read each student's age
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = input.nextInt();
        }

        // Check and display voting eligibility for every student
        for (int i = 0; i < ages.length; i++) {
            boolean eligible = checker.canStudentVote(ages[i]);

            if (eligible) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }

        input.close();
    }
}
