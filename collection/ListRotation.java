import java.util.ArrayList;
import java.util.List;

public class ListRotation {

    static void rotateLeft(List<Integer> list, int positions) {
        int n = list.size();

        if (n == 0) {
            return;
        }

        positions = Math.floorMod(positions, n);

        reverse(list, 0, positions - 1);
        reverse(list, positions, n - 1);
        reverse(list, 0, n - 1);
    }

    static void reverse(List<Integer> list, int left, int right) {
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers =
                new ArrayList<>(List.of(10, 20, 30, 40, 50));

        rotateLeft(numbers, 2);

        System.out.println("Rotated list: " + numbers);
    }
}