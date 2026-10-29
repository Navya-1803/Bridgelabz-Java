import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateArithmeticCalculator {

    public static LocalDate calculateDate(LocalDate date) {
        return date.plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a date (yyyy-MM-dd): ");
        String dateText = input.nextLine();

        try {
            LocalDate originalDate = LocalDate.parse(dateText);
            LocalDate resultDate = calculateDate(originalDate);

            System.out.println("Original date: " + originalDate);
            System.out.println("Final date: " + resultDate);
        } catch (DateTimeParseException exception) {
            System.out.println("Invalid date. Use yyyy-MM-dd.");
        }

        input.close();
    }
}