import java.util.Arrays;

public class InsertionSortEmployeeIds {
    public static void main(String[] args) {
        int[] employeeIds = {105, 102, 108, 101, 104};

        // Start from the second element
        for (int i = 1; i < employeeIds.length; i++) {
            int key = employeeIds[i];
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }

            // Insert key at its correct position
            employeeIds[j + 1] = key;
        }

        System.out.println("Sorted employee IDs: "
                + Arrays.toString(employeeIds));
    }
}