package level3;

import java.util.Scanner;

public class SwitchCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the first number
        System.out.print("Enter the first number: ");
        double first = input.nextDouble();

        // Read the second number
        System.out.print("Enter the second number: ");
        double second = input.nextDouble();

        // Read the operator
        System.out.print("Enter an operator (+, -, *, /): ");
        String op = input.next();

        // Perform the selected arithmetic operation
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;

            case "-":
                System.out.println("Result: " + (first - second));
                break;

            case "*":
                System.out.println("Result: " + (first * second));
                break;

            case "/":
                // Prevent division by zero
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;

            default:
                // Handle any unsupported operator
                System.out.println("Invalid Operator.");
        }

        input.close();
    }
}
