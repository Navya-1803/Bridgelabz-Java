package level1;

import java.util.Scanner;

public class MaximumHandshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Each pair of students can shake hands once
        long handshakes = (long) numberOfStudents
                * (numberOfStudents - 1) / 2;

        System.out.println(
                "The maximum number of handshakes is " + handshakes
        );

        input.close();
    }
}
