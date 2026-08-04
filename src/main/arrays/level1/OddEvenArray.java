import java.util.Scanner;

class OddEvenArray {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number up to which odd and even numbers are generated
        int number = sc.nextInt();

        // Validate input to ensure it is a natural number
        if (number < 1) {
            System.out.println("Error: Not a natural number");
            return;
        }

        // Arrays to store even and odd numbers
        int[] even = new int[number / 2 + 1];
        int[] odd = new int[number / 2 + 1];

        // Index variables for even and odd arrays
        int evenIndex = 0;
        int oddIndex = 0;

        // Separate numbers into even and odd arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print all odd numbers
        System.out.println("Odd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        System.out.println();

        // Print all even numbers
        System.out.println("Even numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }
    }
}