import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MultiTimeZoneClock {

    public static void displayTime(String zoneName, String zoneId) {
        // Get the current date and time in the specified time zone
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of(zoneId));

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        System.out.println(zoneName + ": "
                + currentTime.format(formatter));
    }

    public static void main(String[] args) {
        displayTime("GMT", "GMT");
        displayTime("IST", "Asia/Kolkata");
        displayTime("PST/Pacific Time", "America/Los_Angeles");
    }
}
