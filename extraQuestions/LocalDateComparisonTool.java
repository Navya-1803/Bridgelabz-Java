import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class LocalDateComparisonTool {

    public static void compareDates(LocalDate first, LocalDate second) {
        if (first.isBefore(second)) {
            System.out.println("The first date is before the second date.");
        } else if (first.isAfter(second)) {
            System.out.println("The first date is after the second date.");
        } else if (first.isEqual(second)) {
            System.out.println("Both dates are the same.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter the first date (yyyy-MM-dd): ");
            LocalDate firstDate = LocalDate.parse(input.nextLine());

            System.out.print("Enter the second date (yyyy-MM-dd): ");
            LocalDate secondDate = LocalDate.parse(input.nextLine());

            compareDates(firstDate, secondDate);
        } catch (DateTimeParseException exception) {
            System.out.println("Invalid date format. Use yyyy-MM-dd.");
        }

        input.close();
    }
}
