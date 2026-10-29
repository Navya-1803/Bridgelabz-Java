import java.util.Scanner;

class MeanHeight {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of players
        int players = sc.nextInt();

        // Array to store height of each player
        double[] height = new double[players];

        // Variable to store total height
        double sum = 0;

        // Read heights and calculate total sum
        for (int i = 0; i < players; i++) {
            height[i] = sc.nextDouble();
            sum = sum + height[i];
        }

        // Calculate mean height
        double meanHeight = sum / players;

        // Display mean height of players
        System.out.println("The mean height of the players is " + meanHeight);
    }
}