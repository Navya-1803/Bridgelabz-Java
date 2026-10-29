package level2;

import java.util.Scanner;

public class MeasurementUnitUtility {

    // Convert Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    // Convert Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    // Convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // Convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // Convert liters to gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Fahrenheit: ");
        double fahrenheit = input.nextDouble();
        System.out.printf("Celsius: %.2f%n",
                convertFahrenheitToCelsius(fahrenheit));

        System.out.print("Enter Celsius: ");
        double celsius = input.nextDouble();
        System.out.printf("Fahrenheit: %.2f%n",
                convertCelsiusToFahrenheit(celsius));

        System.out.print("Enter pounds: ");
        double pounds = input.nextDouble();
        System.out.printf("Kilograms: %.4f%n",
                convertPoundsToKilograms(pounds));

        System.out.print("Enter kilograms: ");
        double kilograms = input.nextDouble();
        System.out.printf("Pounds: %.4f%n",
                convertKilogramsToPounds(kilograms));

        System.out.print("Enter gallons: ");
        double gallons = input.nextDouble();
        System.out.printf("Liters: %.4f%n",
                convertGallonsToLiters(gallons));

        System.out.print("Enter liters: ");
        double liters = input.nextDouble();
        System.out.printf("Gallons: %.4f%n",
                convertLitersToGallons(liters));

        input.close();
    }
}
