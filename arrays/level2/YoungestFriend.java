import java.util.Scanner;

class YoungestFriend {
    public static void main(String[] args) {

        // Array to store ages of 3 friends
        int[] age = new int[3];

        // Array to store heights of 3 friends
        int[] height = new int[3];

        // Variables to track youngest age and its index
        int youngInd = 0;
        int young = 100;

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read ages and find the youngest friend
        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            if (age[i] < young) {
                young = age[i];
                youngInd = i;
            }
        }

        // Variables to track maximum height and its index
        int maxHeight = 0;
        int maxInd = 0;

        // Read heights and find the tallest friend
        for (int i = 0; i < 3; i++) {
            height[i] = sc.nextInt();
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxInd = i;
            }
        }

        // Print youngest age and tallest height
        System.out.println("youngest among them " + age[youngInd] +
                " tallest among them " + height[maxInd]);
    }
}