import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number
        int number = sc.nextInt();

        // Temporary variable to process the number
        int temp = number;

        // Count number of digits in the number
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        // Array to store individual digits
        int[] digits = new int[count];

        // Reset temp to original number
        temp = number;
        int index = 0;

        // Extract digits from the number
        while (temp != 0) {
            digits[index] = temp % 10;
            temp = temp / 10;
            index++;
        }

        // Array to store frequency of digits (0–9)
        int[] frequency = new int[10];

        // Count frequency of each digit
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        // Display digit frequency
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " occurs " + frequency[i] + " times");
            }
        }
    }
}