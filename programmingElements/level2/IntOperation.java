package level2;

import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = input.nextInt();

        System.out.print("Enter b: ");
        int b = input.nextInt();

        System.out.print("Enter c: ");
        int c = input.nextInt();

        // Multiplication has higher precedence than addition
        int result1 = a + b * c;

        // Multiplication is performed before addition
        int result2 = a * b + c;

        // Division is performed before addition
        int result3 = c + a / b;

        // Modulus is performed before addition
        int result4 = a % b + c;

        System.out.println("Results of integer operations:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        input.close();
    }
}
