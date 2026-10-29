package level3;

import java.util.Scanner;

public class GregorianMonthCalendar {

    // Store month names in calendar order
    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    // Store the usual number of days in each month
    private static final int[] DAYS_IN_MONTH = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    // Return the name of a month
    public static String getMonthName(int month) {
        return MONTH_NAMES[month - 1];
    }

    // Check whether a year is a leap year
    public static boolean isLeapYear(int year) {
        return year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0);
    }

    // Return the number of days in the given month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return DAYS_IN_MONTH[month - 1];
    }

    // Calculate the weekday of the first day of the month
    // Sunday = 0, Monday = 1, ..., Saturday = 6
    public static int getFirstDayOfMonth(int month, int year) {
        int day = 1;

        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;

        return (day + x + (31 * m0) / 12) % 7;
    }

    // Display the complete calendar
    public static void displayCalendar(int month, int year) {
        int firstDay = getFirstDayOfMonth(month, year);
        int totalDays = getDaysInMonth(month, year);

        System.out.println("\n        " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Add indentation before the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Display all days, moving to a new line after Saturday
        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);

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

        // Validate the inputs
        if (month < 1 || month > 12 || year < 1582) {
            System.out.println("Invalid month or year.");
        } else {
            displayCalendar(month, year);
        }

        input.close();
    }
}
