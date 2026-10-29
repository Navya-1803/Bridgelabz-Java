package level2;

import java.util.Scanner;

public class LeapYearLogical {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // A leap year is divisible by 400, or divisible by 4 but not 100
        if (year >= 1582
                && (year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0))) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        input.close();
    }
}
