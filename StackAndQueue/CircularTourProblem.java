public class CircularTourProblem {

    // Returns the zero-based starting pump, or -1 if impossible.
    static int findStartingPump(int[] petrol, int[] distance) {
        if (petrol == null || distance == null
                || petrol.length == 0
                || petrol.length != distance.length) {
            return -1;
        }

        int start = 0;
        int currentBalance = 0;
        int totalBalance = 0;

        for (int i = 0; i < petrol.length; i++) {
            int difference = petrol[i] - distance[i];

            currentBalance += difference;
            totalBalance += difference;

            // The current start cannot reach pump i + 1.
            if (currentBalance < 0) {
                start = i + 1;
                currentBalance = 0;
            }
        }

        // Insufficient total petrol means no complete tour is possible.
        return totalBalance >= 0 && start < petrol.length ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPump(petrol, distance);

        if (start == -1) {
            System.out.println("No possible starting pump.");
        } else {
            System.out.println("Starting pump index: " + start);
            System.out.println("Starting pump number: " + (start + 1));
        }
    }
}