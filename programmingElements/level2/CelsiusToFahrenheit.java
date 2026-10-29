package level2;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();

        // Convert Celsius to Fahrenheit
        double fahrenheitResult = (celsius * 9.0 / 5.0) + 32;

        System.out.printf("The %.2f Celsius is %.2f Fahrenheit%n",
                celsius, fahrenheitResult);

        input.close();
    }
}