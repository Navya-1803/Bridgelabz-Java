package level2;

import java.util.Scanner;

public class VotingAgeBatchReport {

    // Generate random ages from 10 to 99
    public static int[] generateRandomAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = (int) (Math.random() * 90) + 10;
        }

        return ages;
    }

    // Check whether a student is eligible to vote
    public static boolean canVote(int age) {
        if (age < 0) {
            return false;
        }

        return age >= 18;
    }

    // Create a table containing age and voting eligibility
    public static String[][] createVotingReport(int[] ages) {
        String[][] report = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            report[i][0] = String.valueOf(ages[i]);
            report[i][1] = String.valueOf(canVote(ages[i]));
        }

        return report;
    }

    // Display the voting report
    public static void displayReport(String[][] report) {
        System.out.printf("%-12s %s%n", "Age", "Can Vote?");
        System.out.println("--------------------");

        for (String[] row : report) {
            int age = Integer.parseInt(row[0]);
            boolean eligible = Boolean.parseBoolean(row[1]);

            System.out.printf("%-12d %s%n",
                    age, eligible ? "Yes" : "No");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students (10 for this exercise): ");
        int numberOfStudents = input.nextInt();

        if (numberOfStudents <= 0) {
            System.out.println("Number of students must be positive.");
            input.close();
            return;
        }

        // Generate ages and create the report
        int[] ages = generateRandomAges(numberOfStudents);
        String[][] report = createVotingReport(ages);

        displayReport(report);

        input.close();
    }
}
