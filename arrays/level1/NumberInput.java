import java.util.Scanner;

class NumberInput {
    public static void main(String[] args) {

        // Array to store up to 10 numbers
        double[] num = new double[10];

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Variable to store sum of positive numbers
        double total = 0;

        // Read numbers until a non-positive value is entered
        for (int i = 0; i < num.length; i++) {
            double num2 = sc.nextDouble();
            if (num2 <= 0) {
                break;
            } else {
                num[i] = num2;
                total = total + num2;
            }
        }

        // Print the total sum
        System.out.println(total);
    }
}