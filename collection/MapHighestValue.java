import java.util.HashMap;
import java.util.Map;

public class MapHighestValue {

    static String findHighestKey(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return null;
        }

        String highestKey = null;
        int maximum = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maximum) {
                maximum = entry.getValue();
                highestKey = entry.getKey();
            }
        }

        return highestKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("A", 10);
        scores.put("B", 20);
        scores.put("C", 15);

        System.out.println("Highest value key: "
                + findHighestKey(scores));
    }
}