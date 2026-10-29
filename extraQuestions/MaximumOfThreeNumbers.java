import java.util.Scanner;

public class MaximumOfThreeNumbers {

    // Take an integer input from the user
    public static int readNumber(Scanner input, String message) {
        System.out.print(message);
        return input.nextInt();
    }

    // Return the largest of three numbers
    public static int findMaximum(int first, int second, int third) {
        int maximum = first;

        if (second > maximum) {
            maximum = second;
        }

        if (third > maximum) {
            maximum = third;
        }

        return maximum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int first = readNumber(input, "Enter the first number: ");
        int second = readNumber(input, "Enter the second number: ");
        int third = readNumber(input, "Enter the third number: ");

        System.out.println("Maximum number: "
                + findMaximum(first, second, third));

        input.close();
    }
}
