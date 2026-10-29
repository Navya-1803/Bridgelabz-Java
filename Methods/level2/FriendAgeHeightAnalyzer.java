package level2;

import java.util.Scanner;

public class FriendAgeHeightAnalyzer {

    private static final String[] FRIEND_NAMES = {
            "Amar", "Akbar", "Anthony"
    };

    // Return the index of the youngest friend
    public static int findYoungestFriend(int[] ages) {
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        return youngestIndex;
    }

    // Return the index of the tallest friend
    public static int findTallestFriend(double[] heights) {
        int tallestIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Arrays store the age and height of each friend
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Read the details of all three friends
        for (int i = 0; i < FRIEND_NAMES.length; i++) {
            System.out.print("Enter " + FRIEND_NAMES[i] + "'s age: ");
            ages[i] = input.nextInt();

            System.out.print("Enter " + FRIEND_NAMES[i]
                    + "'s height in cm: ");
            heights[i] = input.nextDouble();
        }

        // Find the youngest and tallest friends
        int youngestIndex = findYoungestFriend(ages);
        int tallestIndex = findTallestFriend(heights);

        System.out.println("Youngest friend: "
                + FRIEND_NAMES[youngestIndex]);
        System.out.println("Tallest friend: "
                + FRIEND_NAMES[tallestIndex]);

        input.close();
    }
}
