import java.util.Scanner;

public class TemperatureConversionUtility {

    // Convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose a conversion: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                double celsius = input.nextDouble();

                System.out.printf("Temperature in Fahrenheit: %.2f°F%n",
                        celsiusToFahrenheit(celsius));
                break;

            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahrenheit = input.nextDouble();

                System.out.printf("Temperature in Celsius: %.2f°C%n",
                        fahrenheitToCelsius(fahrenheit));
                break;

            default:
                System.out.println("Invalid choice.");
        }

        input.close();
    }
}