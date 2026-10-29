import java.util.Scanner;

public class ComputerNumberGuessingGame {

    // Generate a guess within the current range
    public static int generateGuess(int low, int high) {
        return low + (high - low) / 2;
    }

    // Receive feedback from the user
    public static char receiveFeedback(Scanner input, int guess) {
        System.out.println("My guess is: " + guess);
        System.out.print("Enter L (too low), H (too high), C (correct): ");

        return input.next().toUpperCase().charAt(0);
    }

    // Determine the next search range based on feedback
    public static int[] determineNextRange(
            int low, int high, int guess, char feedback) {

        if (feedback == 'L') {
            return new int[]{guess + 1, high};
        } else if (feedback == 'H') {
            return new int[]{low, guess - 1};
        }

        return new int[]{low, high};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;

        System.out.println("Think of a number between 1 and 100.");

        while (low <= high) {
            int guess = generateGuess(low, high);
            char feedback = receiveFeedback(input, guess);

            if (feedback == 'C') {
                System.out.println("I guessed your number!");
                guessedCorrectly = true;
                break;
            } else if (feedback == 'L' || feedback == 'H') {
                int[] nextRange =
                        determineNextRange(low, high, guess, feedback);

                low = nextRange[0];
                high = nextRange[1];
            } else {
                System.out.println("Invalid feedback. Try again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println(
                    "Your feedback was inconsistent. Please restart the game.");
        }

        input.close();
    }
}
