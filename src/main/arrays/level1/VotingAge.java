import java.util.Scanner;

class VotingAge {
    public static void main(String[] args) {

        // Array to store ages of 10 people
        int[] Age = new int[10];

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read ages into the array
        for (int i = 0; i < Age.length; i++) {
            Age[i] = sc.nextInt();
        }

        // Check voting eligibility for each age
        for (int i = 0; i < Age.length; i++) {
            if (Age[i] >= 18) {
                System.out.println(Age[i] + " can vote");
            } else {
                System.out.println(Age[i] + " cannot vote");
            }
        }
    }
}