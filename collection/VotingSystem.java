import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {

    private final Map<String, Integer> votes = new HashMap<>();
    private final Map<String, Integer> voteOrder =
            new LinkedHashMap<>();

    void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);

        voteOrder.put(
                candidate,
                voteOrder.getOrDefault(candidate, 0) + 1
        );
    }

    void displayResults() {
        // TreeMap sorts candidate names
        Map<String, Integer> sortedResults = new TreeMap<>(votes);

        System.out.println("Voting results:");

        sortedResults.forEach((candidate, count) ->
                System.out.println(candidate + ": " + count));
    }

    void displayVoteOrder() {
        System.out.println("\nVote recording order:");

        voteOrder.forEach((candidate, count) ->
                System.out.println(candidate + ": " + count));
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        system.displayResults();
        system.displayVoteOrder();
    }
}