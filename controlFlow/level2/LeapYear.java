package level2;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Gregorian calendar leap-year rules apply from 1582
        if (year < 1582) {
            System.out.println("Year must be 1582 or later.");
        } else if (year % 400 == 0) {
            // Years divisible by 400 are leap years
            System.out.println(year + " is a Leap Year.");
        } else if (year % 100 == 0) {
            // Other century years are not leap years
            System.out.println(year + " is not a Leap Year.");
        } else if (year % 4 == 0) {
            // Other years divisible by 4 are leap years
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        input.close();
    }
}
