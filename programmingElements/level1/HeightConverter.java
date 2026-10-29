package level1;

import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter height in centimeters: ");
        double heightCm = input.nextDouble();

        // Convert centimeters to total inches
        double totalInches = heightCm / 2.54;

        // Calculate whole feet and remaining inches
        int feet = (int) (totalInches / 12);
        double inches = totalInches - (feet * 12);

        System.out.printf(
                "Your height in cm is %.2f while in feet is %d "
                        + "and inches is %.2f%n",
                heightCm, feet, inches
        );

        input.close();
    }
}
