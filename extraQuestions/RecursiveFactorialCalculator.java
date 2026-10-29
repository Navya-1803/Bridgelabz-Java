import java.util.Scanner;

public class RecursiveFactorialCalculator {

    // Calculate factorial recursively
    public static long factorial(int number) {
        // Base case: factorial of 0 and 1 is 1
        if (number == 0 || number == 1) {
            return 1;
        }

        // Recursive case: n! = n * (n - 1)!
        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer (0-20): ");
        int number = input.nextInt();

        if (number < 0 || number > 20) {
            System.out.println("Enter a number between 0 and 20.");
        } else {
            System.out.println("Factorial of " + number
                    + " is " + factorial(number));
        }

        input.close();
    }
}