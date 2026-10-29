public class LinearSearchFirstNegative {

    static int findFirstNegative(int[] numbers) {
        // Search from the beginning of the array
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                return i; // Return the first negative number's index
            }
        }

        return -1; // No negative number found
    }

    public static void main(String[] args) {
        int[] numbers = {12, 7, 0, 5, -8, -3};

        int index = findFirstNegative(numbers);

        if (index != -1) {
            System.out.println("First negative number: " + numbers[index]);
            System.out.println("Index: " + index);
        } else {
            System.out.println("No negative number found.");
        }
    }
}