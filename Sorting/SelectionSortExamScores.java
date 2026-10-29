import java.util.Arrays;

public class SelectionSortExamScores {
    public static void main(String[] args) {
        int[] scores = {85, 62, 91, 47, 73};

        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the unsorted section
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the first unsorted element
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }

        System.out.println("Sorted exam scores: "
                + Arrays.toString(scores));
    }
}