import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatShowcase {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();

        // Define the three required date formats
        DateTimeFormatter format1 =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter format2 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter format3 =
                DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy", Locale.ENGLISH);

        System.out.println("Format 1: " + currentDate.format(format1));
        System.out.println("Format 2: " + currentDate.format(format2));
        System.out.println("Format 3: " + currentDate.format(format3));
    }
}

