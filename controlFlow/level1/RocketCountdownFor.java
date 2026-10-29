package level1;

import java.util.Scanner;

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter countdown starting number: ");
        int counter = input.nextInt();

        // Initialize, check the condition, and decrement in one loop
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Liftoff!");

        input.close();
    }
}
