package level1;

import java.util.Scanner;

public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // A number is divisible by 5 if the remainder is zero
        boolean isDivisible = number % 5 == 0;

        System.out.println("Is the number " + number
                + " divisible by 5? " + isDivisible);

        input.close();
    }
}

