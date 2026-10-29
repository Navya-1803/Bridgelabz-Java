import java.util.HashSet;
import java.util.Set;

public class StringBuilderRemoveDuplicates {

    static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            // Append only if the character has not appeared before
            if (seen.add(current)) {
                result.append(current);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "programming";

        System.out.println("Original string: " + input);
        System.out.println("After removing duplicates: "
                + removeDuplicates(input));
    }
}