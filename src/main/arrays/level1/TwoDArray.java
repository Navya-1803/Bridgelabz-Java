import java.util.Scanner;

class TwoDArray {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of rows and columns
        int row = sc.nextInt();
        int col = sc.nextInt();

        // Declare 2D array with given dimensions
        int[][] arr2D = new int[row][col];

        // Read elements into 2D array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr2D[i][j] = sc.nextInt();
            }
        }

        // Create 1D array to store elements of 2D array
        int[] arr = new int[row * col];

        // Index to track position in 1D array
        int index = 0;

        // Convert 2D array into 1D array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[index] = arr2D[i][j];
                index++;
            }
        }

        // Print elements of the 1D array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}