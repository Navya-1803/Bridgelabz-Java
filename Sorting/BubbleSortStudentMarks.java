import java.util.Arrays;

public class BubbleSortStudentMarks {
    public static void main(String[] args) {
        int[] marks = {78, 45, 92, 56, 67};

        // Compare adjacent elements and swap if out of order
        for (int i = 0; i < marks.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < marks.length - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop early if the array is already sorted
            if (!swapped) {
                break;
            }
        }

        System.out.println("Sorted student marks: "
                + Arrays.toString(marks));
    }
}