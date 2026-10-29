package level2;

import java.util.Scanner;

public class LeapYearMethodValidator {

    // Return true if the year is a Gregorian leap year
    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            return false;
        }

        // Leap years are divisible by 400,
        // or divisible by 4 but not by 100
        return year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if (year < 1582) {
            System.out.println("Year must be 1582 or later.");
        } else if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        input.close();
    }
}
