import java.util.Scanner;

class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();   // Input range limit

        // Validate input
        if (number <= 0) {
            System.out.println("Please enter a positive integer");
            return;
        }

        String[] result = new String[number]; // Array to store FizzBuzz results

        // Store FizzBuzz values in array
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else {
                result[i - 1] = String.valueOf(i);
            }
        }

        // Print each array element with its position
        for (int i = 0; i < number; i++) {
            System.out.println("Position " + (i + 1) + " = " + result[i]);
        }
    }
}