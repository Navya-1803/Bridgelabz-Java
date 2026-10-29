package level2;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();

        // Convert Fahrenheit to Celsius
        double celsiusResult = (fahrenheit - 32) * 5.0 / 9.0;

        System.out.printf("The %.2f Fahrenheit is %.2f Celsius%n",
                fahrenheit, celsiusResult);

        input.close();
    }
}
