package level3;

public class DayOfWeek {
    public static void main(String[] args) {
        // Ensure that month, day, and year are provided
        if (args.length != 3) {
            System.out.println(
                    "Usage: java DayOfWeek <month> <day> <year>"
            );
            return;
        }

        // Parse the command-line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);

        // Validate basic input ranges
        if (month < 1 || month > 12 || day < 1 || day > 31
                || year < 1582) {
            System.out.println("Invalid date or year.");
            return;
        }

        // Calculate the adjusted year
        int y0 = year - (14 - month) / 12;

        // Calculate the year component
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;

        // Calculate the adjusted month
        int m0 = month + 12 * ((14 - month) / 12) - 2;

        // Calculate the day of the week: 0 = Sunday, ..., 6 = Saturday
        int d0 = (day + x + (31 * m0) / 12) % 7;

        // Display the numeric day of the week
        System.out.println("Day of the week: " + d0);
    }
}
