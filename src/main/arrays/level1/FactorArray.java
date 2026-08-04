import java.util.Scanner;

class FactorsArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        int number = sc.nextInt();

        // Initial array size
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        // Tracks number of factors stored
        int index = 0;

        // Check if i is a factor
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {

                // Resize array when capacity is full
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];

                    // Copy existing factors to new array
                    for (int j = 0; j < index; j++) {
                        temp[j] = factors[j];
                    }

                    // Update reference to resized array
                    factors = temp;
                }

                // Store factor
                factors[index] = i;
                index++;
            }
        }

        System.out.println("Factors of " + number + " are:");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
    }
}