import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class InvertMap {

    static <K, V> Map<V, List<K>> invert(Map<K, V> original) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : original.entrySet()) {
            inverted.computeIfAbsent(
                    entry.getValue(),
                    key -> new ArrayList<>()
            ).add(entry.getKey());
        }

        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();

        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);

        System.out.println("Original: " + original);
        System.out.println("Inverted: " + invert(original));
    }
}