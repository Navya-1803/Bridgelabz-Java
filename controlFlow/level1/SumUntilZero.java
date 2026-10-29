package level1;

import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0;

        System.out.print("Enter a number (0 to stop): ");
        double number = input.nextDouble();

        // Continue adding numbers until zero is entered
        while (number != 0) {
            total += number;

            System.out.print("Enter another number (0 to stop): ");
            number = input.nextDouble();
        }

        System.out.println("The total sum is " + total);

        input.close();
    }
}

