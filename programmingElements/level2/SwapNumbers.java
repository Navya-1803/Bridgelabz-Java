package level2;

import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        // Use a temporary variable to swap the values
        int temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println("The swapped numbers are "
                + number1 + " and " + number2);

        input.close();
    }
}
