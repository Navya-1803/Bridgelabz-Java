package level1;

public class SpringSeason {
    public static void main(String[] args) {
        // Read month and day from command-line arguments
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

        // Spring starts March 20 and ends June 20
        boolean isSpring =
                (month == 3 && day >= 20)
                        || month == 4
                        || month == 5
                        || (month == 6 && day <= 20);

        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
