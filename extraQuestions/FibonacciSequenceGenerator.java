import java.util.Scanner;

public class FibonacciSequenceGenerator {

    // Generate and print the Fibonacci sequence
    public static void printFibonacci(int terms) {
        long first = 0;
        long second = 1;

        for (int i = 0; i < terms; i++) {
            System.out.print(first + " ");

            long next = first + second;
            first = second;
            second = next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int terms = input.nextInt();

        if (terms < 0 || terms > 92) {
            System.out.println("Enter a number of terms between 0 and 92.");
        } else {
            printFibonacci(terms);
        }

        input.close();
    }
}