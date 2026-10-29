package level1;

import java.util.Scanner;

public class RocketCountdownWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter countdown starting number: ");
        int counter = input.nextInt();

        // Count down from the entered number to 1
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Liftoff!");

        input.close();
    }
}