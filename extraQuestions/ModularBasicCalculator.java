import java.util.Scanner;

public class ModularBasicCalculator {

    // Addition
    public static double add(double first, double second) {
        return first + second;
    }

    // Subtraction
    public static double subtract(double first, double second) {
        return first - second;
    }

    // Multiplication
    public static double multiply(double first, double second) {
        return first * second;
    }

    // Division
    public static double divide(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        return first / second;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double first = input.nextDouble();

        System.out.print("Enter the second number: ");
        double second = input.nextDouble();

        System.out.println("Choose an operation: +, -, *, /");
        System.out.print("Enter operator: ");
        String operator = input.next();

        try {
            double result;

            switch (operator) {
                case "+":
                    result = add(first, second);
                    break;

                case "-":
                    result = subtract(first, second);
                    break;

                case "*":
                    result = multiply(first, second);
                    break;

                case "/":
                    result = divide(first, second);
                    break;

                default:
                    System.out.println("Invalid operator.");
                    input.close();
                    return;
            }

            System.out.println("Result: " + result);
        } catch (ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}