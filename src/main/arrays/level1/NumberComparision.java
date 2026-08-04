import java.util.Scanner;

class NumberComparision {
    public static void main(String[] args) {

        // Array to store 5 numbers
        int[] num = new int[5];

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read 5 numbers into the array
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        // Check each number for even, odd, negative, or zero
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= 1) {
                if (num[i] % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else if (num[i] < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        // Compare first and last elements of the array
        if (num[0] > num[num.length - 1]) {
            System.out.println("Greater");
        } else if (num[0] < num[num.length - 1]) {
            System.out.println("smaller");
        } else {
            System.out.println("Equal");
        }
    }
}