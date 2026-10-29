package level2;

import java.util.Scanner;

public class FriendComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read ages of the three friends
        System.out.print("Enter Amar's age: ");
        int amarAge = input.nextInt();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = input.nextInt();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = input.nextInt();

        // Read heights of the three friends in centimeters
        System.out.print("Enter Amar's height in cm: ");
        double amarHeight = input.nextDouble();

        System.out.print("Enter Akbar's height in cm: ");
        double akbarHeight = input.nextDouble();

        System.out.print("Enter Anthony's height in cm: ");
        double anthonyHeight = input.nextDouble();

        // Find the youngest friend
        String youngestFriend;
        int youngestAge;

        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            youngestFriend = "Amar";
            youngestAge = amarAge;
        } else if (akbarAge <= anthonyAge) {
            youngestFriend = "Akbar";
            youngestAge = akbarAge;
        } else {
            youngestFriend = "Anthony";
            youngestAge = anthonyAge;
        }

        // Find the tallest friend
        String tallestFriend;
        double tallestHeight;

        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            tallestFriend = "Amar";
            tallestHeight = amarHeight;
        } else if (akbarHeight >= anthonyHeight) {
            tallestFriend = "Akbar";
            tallestHeight = akbarHeight;
        } else {
            tallestFriend = "Anthony";
            tallestHeight = anthonyHeight;
        }

        // Display the results
        System.out.println("Youngest friend: " + youngestFriend
                + ", age: " + youngestAge);
        System.out.println("Tallest friend: " + tallestFriend
                + ", height: " + tallestHeight + " cm");

        input.close();
    }
}
