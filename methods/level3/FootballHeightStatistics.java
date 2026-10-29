package level3;

public class FootballHeightStatistics {

    // Generate a random height between 150 and 250 cm
    public static int generateRandomHeight() {
        return (int) (Math.random() * 101) + 150;
    }

    // Generate heights for all 11 players
    public static int[] generateHeights() {
        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = generateRandomHeight();
        }

        return heights;
    }

    // Calculate the sum of all heights
    public static int calculateSum(int[] heights) {
        int sum = 0;

        for (int height : heights) {
            sum += height;
        }

        return sum;
    }

    // Calculate the mean height
    public static double calculateMean(int[] heights) {
        return (double) calculateSum(heights) / heights.length;
    }

    // Find the shortest height
    public static int findShortest(int[] heights) {
        int shortest = heights[0];

        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }

        return shortest;
    }

    // Find the tallest height
    public static int findTallest(int[] heights) {
        int tallest = heights[0];

        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }

        return tallest;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights();

        System.out.println("Football Player Heights (cm):");

        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + heights[i]);
        }

        System.out.println("Total height: " + calculateSum(heights) + " cm");
        System.out.printf("Mean height: %.2f cm%n", calculateMean(heights));
        System.out.println("Shortest height: " + findShortest(heights) + " cm");
        System.out.println("Tallest height: " + findTallest(heights) + " cm");
    }
}
