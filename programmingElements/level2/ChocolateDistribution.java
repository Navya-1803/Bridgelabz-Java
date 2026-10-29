package level2;

import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        if (numberOfChocolates >= 0 && numberOfChildren > 0) {
            // Calculate chocolates per child
            int chocolatesPerChild =
                    numberOfChocolates / numberOfChildren;

            // Calculate chocolates remaining
            int remainingChocolates =
                    numberOfChocolates % numberOfChildren;

            System.out.println(
                    "The number of chocolates each child gets is "
                            + chocolatesPerChild
                            + " and the number of remaining chocolates are "
                            + remainingChocolates
            );
        } else {
            System.out.println(
                    "Chocolates cannot be negative and children must be greater than zero."
            );
        }

        input.close();
    }
}