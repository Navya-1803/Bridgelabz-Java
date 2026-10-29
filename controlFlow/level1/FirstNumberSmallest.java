package level1;

import java.util.Scanner;

public class FirstNumberSmallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number1: ");
        int number1 = input.nextInt();

        System.out.print("Enter number2: ");
        int number2 = input.nextInt();

        System.out.print("Enter number3: ");
        int number3 = input.nextInt();

        // Check whether the first number is less than or equal to both others
        boolean isSmallest = number1 <= number2 && number1 <= number3;

        System.out.println("Is the first number the smallest? " + isSmallest);

        input.close();
    }
}
