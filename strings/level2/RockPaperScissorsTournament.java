package level2;

import java.util.Scanner;

public class RockPaperScissorsTournament {

    // Generate the computer's choice randomly
    // 0 = Rock, 1 = Paper, 2 = Scissors
    public static int getComputerChoice() {
        return (int) (Math.random() * 3);
    }

    // Convert a numeric choice into its name
    public static String getChoiceName(int choice) {
        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return "Invalid";
        }
    }

    // Determine the winner: 1 = player, -1 = computer, 0 = draw
    public static int findWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0;
        }

        if ((playerChoice == 0 && computerChoice == 2)
                || (playerChoice == 1 && computerChoice == 0)
                || (playerChoice == 2 && computerChoice == 1)) {
            return 1;
        }

        return -1;
    }

    // Calculate win statistics for both participants
    // Rows: player, computer; columns: wins, percentage
    public static String[][] calculateStatistics(
            int playerWins, int computerWins, int totalGames) {

        String[][] statistics = new String[2][2];

        double playerPercentage =
                (double) playerWins / totalGames * 100;

        double computerPercentage =
                (double) computerWins / totalGames * 100;

        statistics[0][0] = String.valueOf(playerWins);
        statistics[0][1] = String.format("%.2f", playerPercentage);

        statistics[1][0] = String.valueOf(computerWins);
        statistics[1][1] = String.format("%.2f", computerPercentage);

        return statistics;
    }

    // Display the statistics table
    public static void displayStatistics(
            String[][] statistics, int draws) {

        System.out.printf("%-15s %-10s %-15s%n",
                "Participant", "Wins", "Win Percentage");

        System.out.println("------------------------------------------");

        System.out.printf("%-15s %-10s %-15s%%%n",
                "Player", statistics[0][0], statistics[0][1]);

        System.out.printf("%-15s %-10s %-15s%%%n",
                "Computer", statistics[1][0], statistics[1][1]);

        System.out.println("Draws: " + draws);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of games: ");
        int totalGames = input.nextInt();

        if (totalGames <= 0) {
            System.out.println("Number of games must be positive.");
            input.close();
            return;
        }

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        System.out.println("\nChoose 0 for Rock, 1 for Paper, 2 for Scissors.");

        // Play the requested number of games
        for (int i = 1; i <= totalGames; i++) {
            System.out.print("Game " + i + " - Your choice: ");
            int playerChoice = input.nextInt();

            if (playerChoice < 0 || playerChoice > 2) {
                System.out.println("Invalid choice. Try this game again.");
                i--;
                continue;
            }

            int computerChoice = getComputerChoice();
            int winner = findWinner(playerChoice, computerChoice);

            System.out.println("You chose: "
                    + getChoiceName(playerChoice));

            System.out.println("Computer chose: "
                    + getChoiceName(computerChoice));

            if (winner == 1) {
                System.out.println("You win!");
                playerWins++;
            } else if (winner == -1) {
                System.out.println("Computer wins!");
                computerWins++;
            } else {
                System.out.println("It's a draw!");
                draws++;
            }

            System.out.println();
        }

        // Calculate and display final win statistics
        String[][] statistics = calculateStatistics(
                playerWins, computerWins, totalGames);

        System.out.println("Final Tournament Statistics");
        displayStatistics(statistics, draws);

        input.close();
    }
}
