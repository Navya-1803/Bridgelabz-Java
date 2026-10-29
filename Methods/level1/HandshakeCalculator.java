package level1;

import java.util.Scanner;

public class HandshakeCalculator {

    // Calculate the maximum handshakes using n * (n - 1) / 2
    public static long calculateHandshakes(int numberOfStudents) {
        return (long) numberOfStudents * (numberOfStudents - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        if (numberOfStudents < 0) {
            System.out.println("Number of students cannot be negative.");
        } else {
            // Call the method to calculate handshakes
            long handshakes = calculateHandshakes(numberOfStudents);

            System.out.println("Maximum number of handshakes: "
                    + handshakes);
        }

        input.close();
    }
}
