package level1;

public class Spring {

    // Return true if the date falls within the spring season
    public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20 && day <= 31)
                || (month == 4 && day >= 1 && day <= 30)
                || (month == 5 && day >= 1 && day <= 31)
                || (month == 6 && day >= 1 && day <= 20);
    }

    public static void main(String[] args) {
        // Check that both command-line arguments are provided
        if (args.length != 2) {
            System.out.println("Usage: java SpringSeason <month> <day>");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Validate basic month and day ranges
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("Invalid date.");
            return;
        }

        // Call the method to check the season
        if (isSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
