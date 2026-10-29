package level1;

import java.util.Scanner;

public class WindChillCalculator {

    // Calculate wind chill using the given formula
    public static double calculateWindChill(
            double temperature, double windSpeed) {

        return 35.74
                + 0.6215 * temperature
                + (0.4275 * temperature - 35.75)
                * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double temperature = input.nextDouble();

        System.out.print("Enter wind speed in miles per hour: ");
        double windSpeed = input.nextDouble();

        // Validate the inputs for the standard wind chill formula
        if (temperature <= 50 && windSpeed > 3) {
            // Calculate the wind chill using the method
            double windChill = calculateWindChill(temperature, windSpeed);

            System.out.printf("Wind chill temperature: %.2f°F%n", windChill);
        } else {
            System.out.println(
                    "For this formula, temperature must be at most 50°F "
                            + "and wind speed must exceed 3 mph.");
        }

        input.close();
    }
}
