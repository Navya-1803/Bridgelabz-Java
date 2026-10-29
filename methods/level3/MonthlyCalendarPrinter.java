package level3;

import java.util.Scanner;

public class MonthlyCalendarPrinter {

    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    private static final int[] DAYS_IN_MONTH = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    // Check for a leap year in the Gregorian calendar
    public static boolean isLeapYear(int year) {
        return year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0);
    }

    // Return the name of the month
    public static String getMonthName(int month) {
        return MONTH_NAMES[month - 1];
    }

    // Return the number of days in the requested month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return DAYS_IN_MONTH[month - 1];
    }

    // Calculate the weekday of the first day: 0 = Sunday, ..., 6 = Saturday
    public static int getFirstDayOfMonth(int month, int year) {
        int day = 1;

        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;

        return (day + x + (31 * m0) / 12) % 7;
    }

    // Print the complete monthly calendar
    public static void displayCalendar(int month, int year) {
        int firstDay = getFirstDayOfMonth(month, year);
        int totalDays = getDaysInMonth(month, year);

        System.out.println("\n    " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print spaces for weekdays before the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Print all dates with a field width of three
        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);

            // Move to a new line after Saturday
            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter year (1582 or later): ");
        int year = input.nextInt();

        if (month < 1 || month > 12 || year < 1582) {
            System.out.println("Invalid month or year.");
        } else {
            displayCalendar(month, year);
        }

        input.close();
    }
}
