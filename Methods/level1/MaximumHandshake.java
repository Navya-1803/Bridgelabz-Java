package level1;

import java.util.Scanner;

public class MaximumHandshake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        if (numberOfStudents < 0) {
            System.out.println("Number of students cannot be negative.");
        } else {
            // Calculate maximum handshakes directly
            long handshakes =
                    (long) numberOfStudents * (numberOfStudents - 1) / 2;

            System.out.println("Maximum number of handshakes: "
                    + handshakes);
        }

        input.close();
    }
}
