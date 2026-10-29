package level1;

import java.util.Scanner;

public class SumUntilNonPositive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0;

        // Keep accepting numbers until the loop is explicitly stopped
        while (true) {
            System.out.print("Enter a positive number (0 or negative to stop): ");
            double number = input.nextDouble();

            // Exit without adding zero or a negative number
            if (number <= 0) {
                break;
            }

            total += number;
        }

        System.out.println("The total sum is " + total);

        input.close();
    }
}
