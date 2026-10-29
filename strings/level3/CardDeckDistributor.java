package level3;

import java.util.Scanner;

public class CardDeckDistributor {

    // Define the four suits
    private static final String[] SUITS = {
            "Hearts", "Diamonds", "Clubs", "Spades"
    };

    // Define the thirteen ranks
    private static final String[] RANKS = {
            "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King", "Ace"
    };

    // Initialize the deck and return all cards
    public static String[] initializeDeck() {
        int numberOfCards = SUITS.length * RANKS.length;
        String[] deck = new String[numberOfCards];

        int index = 0;

        // Create every combination of rank and suit
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }

        return deck;
    }

    // Shuffle the deck using random swaps
    public static String[] shuffleDeck(String[] deck) {
        // Work on a copy so the original deck is preserved
        String[] shuffledDeck = new String[deck.length];

        for (int i = 0; i < deck.length; i++) {
            shuffledDeck[i] = deck[i];
        }

        // Swap each card with a random card from the remaining deck
        for (int i = 0; i < shuffledDeck.length; i++) {
            int randomCardNumber = i
                    + (int) (Math.random() * (shuffledDeck.length - i));

            String temporary = shuffledDeck[i];
            shuffledDeck[i] = shuffledDeck[randomCardNumber];
            shuffledDeck[randomCardNumber] = temporary;
        }

        return shuffledDeck;
    }

    // Distribute cards equally among players
    // Each row represents one player
    public static String[][] distributeCards(
            String[] deck, int numberOfPlayers) {

        if (numberOfPlayers <= 0) {
            throw new IllegalArgumentException(
                    "Number of players must be positive.");
        }

        if (deck.length % numberOfPlayers != 0) {
            throw new IllegalArgumentException(
                    "The cards cannot be distributed equally among "
                            + numberOfPlayers + " players.");
        }

        int cardsPerPlayer = deck.length / numberOfPlayers;
        String[][] players = new String[numberOfPlayers][cardsPerPlayer];

        int cardIndex = 0;

        // Deal cards one by one to each player in turn
        for (int card = 0; card < cardsPerPlayer; card++) {
            for (int player = 0; player < numberOfPlayers; player++) {
                players[player][card] = deck[cardIndex];
                cardIndex++;
            }
        }

        return players;
    }

    // Display every player's cards
    public static void displayPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");

            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }

            System.out.println("Total cards: " + players[i].length);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create and shuffle a standard 52-card deck
        String[] deck = initializeDeck();
        String[] shuffledDeck = shuffleDeck(deck);

        System.out.println("Total cards in the deck: " + deck.length);

        System.out.print("Enter the number of players: ");
        int numberOfPlayers = input.nextInt();

        try {
            // Distribute the shuffled deck
            String[][] players = distributeCards(
                    shuffledDeck, numberOfPlayers);

            // Display the cards received by each player
            displayPlayers(players);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}
