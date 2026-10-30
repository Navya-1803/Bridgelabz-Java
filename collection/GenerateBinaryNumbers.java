import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryNumbers {

    static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        if (n <= 0) {
            return result;
        }

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();

            result.add(current);

            // Generate the next two binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(generate(n));
    }
}