package level2;

import java.util.Scanner;

public class MultiplesBelowHundred {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return;
        }

        System.out.println("Multiples of " + number + " below 100:");

        // Iterate backward from 100 to 1
        for (int i = 100; i >= 1; i--) {
            // A multiple is divisible by the input number
            if (i % number == 0) {
                System.out.println(i);
            }
        }

        input.close();
    }
}
