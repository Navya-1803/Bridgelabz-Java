package level2;

import java.util.Scanner;

public class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number < 1) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return;
        }

        int counter = 0;

        // Continue until the counter exceeds the input
        while (counter <= number) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (counter % 3 == 0) {
                System.out.println("Fizz");
            } else if (counter % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(counter);
            }

            // Move to the next number
            counter++;
        }

        input.close();
    }
}
